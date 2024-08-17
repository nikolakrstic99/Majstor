package com.master.myMaster.repository;

import com.master.myMaster.entities.ReviewEntity;
import com.master.myMaster.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findByRatedUser(UserEntity rated_user_id);
    List<ReviewEntity> findByCreatorUser(UserEntity creator_user_id);
    Boolean existsByCreatorUserIdAndRatedUserId(Long creator_user_id, Long rated_user_id);
}
