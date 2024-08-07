package com.master.app.data.repository

import com.master.app.data.model.LoginRequest
import com.master.app.data.model.UserApiModel
import com.master.app.data.source.RetrofitInstance
import retrofit2.Response

class UserRepositoryImpl: UserRepository {
    override suspend fun login(loginRequest: LoginRequest): Response<UserApiModel> =
        RetrofitInstance.api.login(loginRequest)
}