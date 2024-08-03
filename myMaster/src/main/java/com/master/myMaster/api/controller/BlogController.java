package com.master.myMaster.api.controller;

import com.master.myMaster.domains.Blog;
import com.master.myMaster.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/blog")
public class BlogController {

  private final BlogService blogService;
  @PostMapping
  public ResponseEntity<Blog> createBlog() {
    return ResponseEntity.ok(new Blog());
  }

  @DeleteMapping
  public ResponseEntity<Void> deleteBlog() {
    return ResponseEntity.noContent().build();
  }
}
