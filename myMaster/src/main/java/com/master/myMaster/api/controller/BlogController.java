package com.master.myMaster.api.controller;

import com.master.myMaster.api.request.AddBlogRequest;
import com.master.myMaster.common.config.UserAuthProvider;
import com.master.myMaster.domains.Blog;
import com.master.myMaster.domains.BlogImage;
import com.master.myMaster.domains.ServiceImage;
import com.master.myMaster.service.BlogImageService;
import com.master.myMaster.service.BlogService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/blog")
public class BlogController {

  private final BlogService blogService;
  private final BlogImageService blogImageService;
  private final UserAuthProvider userAuthProvider;
  @PostMapping
  public ResponseEntity<Blog> createBlog(@RequestBody AddBlogRequest request) {
    return ResponseEntity.ok(blogService.addBlog(request, userAuthProvider.getUser()));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
    blogService.deleteBlog(id);
    blogImageService.deleteImagesWithBlogId(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public List<Blog> getAllBlogs() {
    return blogService.getAllBlogs();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Blog> getBlog(@PathVariable Long id) {
    return ResponseEntity.ok(blogService.getBlog(id));
  }
  @GetMapping("/images/{id}")
  public List<BlogImage> getImages(@PathVariable("id") Long id) {
    return blogImageService.getImages(id);
  }
}
