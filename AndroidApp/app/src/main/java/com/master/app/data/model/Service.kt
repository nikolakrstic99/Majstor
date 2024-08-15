package com.master.app.data.model

data class Service(
    val id: Int,
    val topLevelCategory: String,
    val category: String,
    val description: String,
    val user: User,
    val images: List<ServiceImage> = listOf()
)
