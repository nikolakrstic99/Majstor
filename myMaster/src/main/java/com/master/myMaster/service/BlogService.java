package com.master.myMaster.service;

import com.master.myMaster.api.request.AddBlogRequest;
import com.master.myMaster.domains.Blog;
import com.master.myMaster.domains.BlogImage;
import com.master.myMaster.domains.User;
import com.master.myMaster.entities.BlogEntity;
import com.master.myMaster.mapper.BlogImageMapper;
import com.master.myMaster.mapper.BlogMapper;
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
  private final BlogImageService blogImageService;
  private final BlogImageMapper blogImageMapper;

  @Transactional
  public Blog addBlog(AddBlogRequest request, User principalUser) {
    var blog = blogMapper.toBlog(request);
    var user = userService.findByEmail(principalUser.getEmail());
    blog.setCreatedAt(LocalDateTime.now());
    blog.setUser(user);
    var blogEntity = save(blog);
    blog.setId(blogEntity.getId());
    for (var file : request.files()) {
      var blogImage = new BlogImage();
      blogImage.setBlogId(blogEntity.getId());
      blogImage.setImageData(file);
      blogImageService.save(blogImageMapper.toEntity(blogImage));
    }
    return blog;
  }

  @Transactional
  public BlogEntity save(Blog blog) {
    return blogRepository.save(blogMapper.toBlogEntity(blog));
  }

  public void deleteBlog(Long id) {
    blogRepository.deleteById(id);
  }

  @Transactional
  public Blog getBlog(Long id) {
    return blogRepository.findById(id).map(blogMapper::toBlog).orElseThrow();
  }

  @Transactional
  public List<Blog> getAllBlogs() {
    return blogRepository.findAll().stream().map(blogMapper::toBlog).toList();
  }
}
