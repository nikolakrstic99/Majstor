package com.master.app.data.entity

data class RegisterRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
)
