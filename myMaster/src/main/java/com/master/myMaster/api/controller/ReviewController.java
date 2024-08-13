package com.master.myMaster.api.controller;

import com.master.myMaster.api.request.AddReviewRequest;
import com.master.myMaster.common.config.UserAuthProvider;
import com.master.myMaster.domains.Review;
import com.master.myMaster.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/review")
public class ReviewController {

  private final ReviewService reviewService;
  private final UserAuthProvider userAuthProvider;

  @PostMapping
  public ResponseEntity<Review> createReview(@RequestBody AddReviewRequest request) {
    return ResponseEntity.ok(reviewService.addReview(request, userAuthProvider.getUser()));
  }

  @GetMapping("ratedUser/{userId}")
  public List<Review> getReviewsByCreatorUser(@PathVariable Integer userId) {
    return reviewService.getReviewsByRatedUser(userId);
  }

  @GetMapping("creatorUser")
  public List<Review> getReviewsByCreatorUser() {
    return reviewService.getReviewsByCreatorUser(userAuthProvider.getUser());
  }
}
