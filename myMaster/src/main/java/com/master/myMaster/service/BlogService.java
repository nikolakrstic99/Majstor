package com.master.myMaster.service;

import com.master.myMaster.api.request.AddBlogRequest;
import com.master.myMaster.domains.Blog;
import com.master.myMaster.mapper.BlogMapper;
import com.master.myMaster.repository.BlogRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {

  private final BlogRepository blogRepository;
  private final UserService userService;
  private final BlogMapper blogMapper;

  public Blog addBlog(AddBlogRequest request) {
    var blog = blogMapper.toBlog(request);
    blog.setCreatedAt(LocalDateTime.now());
    //var user = userService.getUser(request.getUserId());
    var entity = blogRepository.save(blogMapper.toBlogEntity(blog));
    return blogMapper.toBlog(entity);
  }

  public void deleteBlog(Long id) {
    blogRepository.deleteById(id);
  }

}
