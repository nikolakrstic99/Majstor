package com.master.app.data.source

import com.master.app.data.entity.LoginRequest
import com.master.app.data.entity.RegisterRequest
import com.master.app.data.entity.UserApiModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<UserApiModel>

    @POST("register")
    suspend fun register(@Body request: RegisterRequest): Response<UserApiModel>
}