package com.master.myMaster.api.request;

public record AddReviewRequest(Long ratedUserId, String text, Integer rating) {
}
