package com.master.app.data.model

import com.master.app.common.UserType

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val type: UserType,
    val token: String?,
    val rating: Double = 3.0
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        return id == other.id
    }

    override fun hashCode(): Int {
        return id
    }
}