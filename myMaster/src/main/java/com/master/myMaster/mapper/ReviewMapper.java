package com.master.myMaster.mapper;

import com.master.myMaster.api.request.AddReviewRequest;
import com.master.myMaster.domains.Review;
import com.master.myMaster.entities.ReviewEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ReviewMapper {

  Review toDomain(ReviewEntity entity);

  ReviewEntity toEntity(Review review);

  Review toDomain(AddReviewRequest request);
}
