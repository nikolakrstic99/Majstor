package com.master.myMaster.service;

import com.master.myMaster.api.request.AddBlogRequest;
import com.master.myMaster.domains.Blog;
import com.master.myMaster.domains.UserDto;
import com.master.myMaster.mapper.BlogMapper;
import com.master.myMaster.repository.BlogRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {

  private final BlogRepository blogRepository;
  private final UserService userService;
  private final BlogMapper blogMapper;

  @Transactional
  public Blog addBlog(AddBlogRequest request, UserDto principalUser) {
    var blog = blogMapper.toBlog(request);
    var user = userService.findByEmail(principalUser.getEmail());
    blog.setCreatedAt(LocalDateTime.now());
    blog.setUser(user);
    userService.save(user);
    var entity = blogRepository.save(blogMapper.toBlogEntity(blog));
    return blogMapper.toBlog(entity);
  }

  public void deleteBlog(Long id) {
    blogRepository.deleteById(id);
  }

}
