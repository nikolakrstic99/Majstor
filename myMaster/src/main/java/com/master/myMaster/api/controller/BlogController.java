package com.master.myMaster.api.controller;

import com.master.myMaster.api.request.AddBlogRequest;
import com.master.myMaster.domains.Blog;
import com.master.myMaster.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
  @PostMapping
  public ResponseEntity<Blog> createBlog(@RequestBody AddBlogRequest request) {
    return ResponseEntity.ok(blogService.addBlog(request));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
    blogService.deleteBlog(id);
    return ResponseEntity.ok().build();
  }
}
