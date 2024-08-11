package com.master.app.data.entity

data class AddServiceRequest(
    val l1Category: String,
    val l2Category: String,
    val description: String,
    val files: List<String>
)
