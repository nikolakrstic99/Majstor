package com.master.app.data.repository

import com.master.app.data.model.User
import retrofit2.Response

interface UserRepository {
    suspend fun login(email: String, password: String): Resource<User>
}