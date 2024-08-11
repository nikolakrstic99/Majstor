package com.master.app.data.entity

data class ServiceApiModel(
    val id: Int,
    val l1Category: String,
    val l2Category: String,
    val description: String,
    val user: UserApiModel
)
