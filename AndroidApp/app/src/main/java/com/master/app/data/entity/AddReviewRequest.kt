package com.master.app.data.entity

data class AddReviewRequest(
    val ratedUserId: Int,
    val text: String,
    val rating: Int
)
