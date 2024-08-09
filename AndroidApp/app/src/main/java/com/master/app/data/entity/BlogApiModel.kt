package com.master.app.data.entity

data class BlogApiModel(
    val id: Int,
    val heading: String,
    val subHeading: String,
    val details: String,
    val user: UserApiModel,
    val createdAt: String
)
