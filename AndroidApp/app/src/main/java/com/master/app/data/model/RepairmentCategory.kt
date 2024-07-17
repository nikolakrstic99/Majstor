package com.master.app.data.model

// Should be used for both general repairment category (e.g. Construction or Electronics),
// and for it's subcategories (e.g. Parquet and Ceramics of Construction category).
data class RepairmentCategory(
    val id: Int,
    val name: String,
    val repairmenCount: Int,
    val picture: String
)
