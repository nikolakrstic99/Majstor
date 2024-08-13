package com.master.myMaster.service;

import com.master.myMaster.api.request.AddBlogRequest;
import com.master.myMaster.api.request.AddReviewRequest;
import com.master.myMaster.domains.Blog;
import com.master.myMaster.domains.BlogImage;
import com.master.myMaster.domains.Review;
import com.master.myMaster.domains.User;
import com.master.myMaster.entities.BlogEntity;
import com.master.myMaster.entities.ReviewEntity;
import com.master.myMaster.entities.ServiceEntity;
import com.master.myMaster.mapper.BlogImageMapper;
import com.master.myMaster.mapper.BlogMapper;
import com.master.myMaster.mapper.ReviewMapper;
import com.master.myMaster.mapper.UserMapper;
import com.master.myMaster.repository.BlogRepository;
import com.master.myMaster.repository.ReviewRepository;
import com.master.myMaster.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
  private final ReviewRepository reviewRepository;
  private final ReviewMapper reviewMapper;
  private final UserService userService;
  private final UserMapper userMapper;

  private ReviewEntity save(Review review) {
    return reviewRepository.save(reviewMapper.toEntity(review));
  }

  public Review addReview(AddReviewRequest addReviewRequest, User principalUser) {
    var review = reviewMapper.toDomain(addReviewRequest);
    var ratedUser = userService.getUser(addReviewRequest.ratedUserId());
    var creatorUser = userService.findByEmail(principalUser.getEmail());
    review.setRatedUser(ratedUser);
    review.setCreatorUser(creatorUser);
    review.setCreatedAt(LocalDateTime.now());
    save(review);
    return review;
  }

  public List<Review> getReviewsByRatedUser(Integer userId) {
    var user = userService.getUser(userId.longValue());
    return reviewRepository
            .findByRatedUser(userMapper.toEntity(user))
            .stream()
            .map(reviewMapper::toDomain)
            .toList();
  }

  public List<Review> getReviewsByCreatorUser(User principalUser) {
    var user = userService.findByEmail(principalUser.getEmail());
    return reviewRepository
            .findByCreatorUser(userMapper.toEntity(user))
            .stream()
            .map(reviewMapper::toDomain)
            .toList();
  }
}
