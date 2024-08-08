package com.master.app.ui.model

data class Repairman(
    val id: Int,
    val name: String,
    val averageRating: Double,
    val phoneNumber: String,
    // One repairman can be in multiple categories (e.g. parquet or ceramist)
    val categories: List<String>
)
