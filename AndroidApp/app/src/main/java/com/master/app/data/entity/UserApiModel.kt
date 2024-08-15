package com.master.app.data.entity

import com.master.app.common.UserType

data class UserApiModel(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val status: UserType,
    val phone: String,
    val location: String,
    val token: String?
)
