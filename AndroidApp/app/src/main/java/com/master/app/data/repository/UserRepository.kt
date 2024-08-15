package com.master.app.data.repository

import com.master.app.data.model.User

interface UserRepository {
    suspend fun login(email: String, password: String): Resource<User>
    suspend fun register(firstName: String, lastName: String, email: String, password: String, phoneNumber: String, location: String):
            Resource<User>
    suspend fun getLoggedUser(): Resource<User>
    suspend fun isUserLoggedIn(): Boolean
    suspend fun getUser(id: Int): Resource<User>
    fun logout()
}