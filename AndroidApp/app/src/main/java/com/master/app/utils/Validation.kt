package com.master.app.utils

fun isEmailValid(email: String): Boolean {
    val validPattern = "^[A-Za-z0-9+_.-]+@(.+)$".toRegex()
    return email.matches(validPattern)
}

fun isPasswordValid(password: String): Boolean {
    val validPattern = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}\$\n".toRegex()
    return password.matches(validPattern)
}