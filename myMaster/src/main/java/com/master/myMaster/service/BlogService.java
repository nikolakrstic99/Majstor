package com.master.myMaster.service;

import com.master.myMaster.api.request.AddBlogRequest;
import com.master.myMaster.domains.Blog;
import com.master.myMaster.domains.Image;
import com.master.myMaster.domains.User;
import com.master.myMaster.mapper.BlogMapper;
import com.master.myMaster.mapper.ImageMapper;
import com.master.myMaster.repository.BlogRepository;
import com.master.myMaster.utils.Utils;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {

  private final BlogRepository blogRepository;
  private final UserService userService;
  private final BlogMapper blogMapper;
  private final ImageService imageService;

  @Transactional
  public Blog addBlog(AddBlogRequest request, User principalUser) {
    var blog = blogMapper.toBlog(request);
    var user = userService.findByEmail(principalUser.getEmail());
    blog.setCreatedAt(LocalDateTime.now());

    for (var file : request.files()) {
      var image = new Image();
      image.setImageData(Utils.decodeImage(file));
      //imageService.save(image);
      blog.addImage(image);
    }
    //save(blog);
    user.addBlog(blog);
    userService.save(user);
    return blog;
  }

  @Transactional
  public void save(Blog blog) {
    blogRepository.save(blogMapper.toBlogEntity(blog));
  }

  public void deleteBlog(Long id) {
    blogRepository.deleteById(id);
  }

  @Transactional
  public List<Blog> getAllBlogs() {
    return blogRepository.findAll().stream().map(blogMapper::toBlog).toList();
  }
}
