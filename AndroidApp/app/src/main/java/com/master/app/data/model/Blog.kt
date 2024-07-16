package com.master.app.data.model

data class BlogInfo(
    val id: Int,
    val title: String,
    val description: String,
    val picture: String,
    val publishTime: String,
    val author: String
)

data class Blog(
    val info: BlogInfo,
    val text: String,
    val pictures: List<String>,
)
