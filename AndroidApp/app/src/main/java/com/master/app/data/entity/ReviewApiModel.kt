package com.master.app.data.entity

data class ReviewApiModel(
    val id: Int,
    val ratedUser: UserApiModel,
    val creatorUser: UserApiModel,
    val text: String,
    val rating: Int,
    val createdAt: String
)
