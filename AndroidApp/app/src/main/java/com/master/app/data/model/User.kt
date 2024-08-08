package com.master.app.data.model

import com.master.app.common.UserType

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val type: UserType,
    val token: String
)
