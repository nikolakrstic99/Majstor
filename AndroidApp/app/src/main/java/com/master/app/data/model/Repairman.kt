package com.master.app.data.model

data class Repairman(
    val id: Int,
    val name: String,
    val averageScore: Float,
    val categoryId: Int // Subcategory ID
)
