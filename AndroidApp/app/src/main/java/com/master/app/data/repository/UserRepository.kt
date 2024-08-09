package com.master.app.data.repository

import com.master.app.data.model.User
import com.master.app.data.source.LocalStorageManager

interface UserRepository {
    suspend fun login(email: String, password: String): Resource<User>
    suspend fun register(firstName: String, lastName: String, email: String, password: String):
            Resource<User>
    suspend fun getLoggedUser(): Resource<User>
    suspend fun isUserLoggedIn(): Boolean
}