package com.master.app.data.repository

import com.master.app.data.model.LoginRequest
import com.master.app.data.model.UserApiModel
import retrofit2.Response

interface UserRepository {
    suspend fun login(loginRequest: LoginRequest): Response<UserApiModel>
}