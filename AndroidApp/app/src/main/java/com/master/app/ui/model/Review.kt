package com.master.app.ui.model

data class Review(
    val id: Int,
    val author: String,
    val repairmanId: Int,
    val rating: Int,
    val comment: String,
    val date: String
)
