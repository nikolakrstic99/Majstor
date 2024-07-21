package com.master.app.data.model

data class Review(
    val id: Int,
    val author: String,
    val repairmanId: Int,
    val rating: Int,
    val comment: String,
    val date: String
)
