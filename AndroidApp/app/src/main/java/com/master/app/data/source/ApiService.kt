package com.master.app.data.source

import com.master.app.data.model.LoginRequest
import com.master.app.data.model.UserApiModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<UserApiModel>
}