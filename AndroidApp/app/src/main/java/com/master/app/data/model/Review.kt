package com.master.app.data.model

data class Review(
    val id: Int,
    val ratedUser: User,
    val creatorUser: User,
    val text: String,
    val rating: Int,
    val createdAt: String
)
