package com.master.app.data.repository

import com.master.app.data.entity.LoginRequest
import com.master.app.data.model.User
import com.master.app.data.source.RetrofitInstance
import retrofit2.Response

class UserRepositoryImpl: UserRepository {
    override suspend fun login(email: String, password: String): Resource<User> {
        val response = RetrofitInstance.api.login(LoginRequest(email, password))
        if (!response.isSuccessful) {
            return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
        }
        val body = response.body()!!
        return Resource.Success(
            User(
                id = body.id,
                firstName = body.firstName,
                lastName = body.lastName,
                email = body.email,
                password = body.password,
                status = body.status,
                token = body.token
            )
        )
    }
}