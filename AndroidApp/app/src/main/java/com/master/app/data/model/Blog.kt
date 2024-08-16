package com.master.app.data.model

data class Blog(
    val id: Int,
    val title: String,
    val description: String,
    val text: String,
    val author: User,
    val createdAt: String,
    val images: List<Image> = listOf()
)
