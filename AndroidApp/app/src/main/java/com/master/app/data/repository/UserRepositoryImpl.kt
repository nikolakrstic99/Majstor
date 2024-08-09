package com.master.app.data.repository

import com.master.app.data.entity.LoginRequest
import com.master.app.data.entity.RegisterRequest
import com.master.app.data.model.User
import com.master.app.data.source.LocalStorageManager
import com.master.app.data.source.RetrofitInstance
import com.master.app.data.utils.fromUserApiToUser
import retrofit2.Response

class UserRepositoryImpl: UserRepository {
    override suspend fun login(email: String, password: String): Resource<User> {
        val response = RetrofitInstance.api.login(LoginRequest(email, password))
        if (!response.isSuccessful) {
            return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
        }
        return Resource.Success(fromUserApiToUser(response.body()!!))
    }

    override suspend fun register(firstName: String, lastName: String, email: String, password: String
    ): Resource<User> {
        val response = RetrofitInstance.api.register(RegisterRequest(
            firstName = firstName,
            lastName = lastName,
            email = email,
            password = password
        ))
        if (!response.isSuccessful) {
            return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
        }
        return Resource.Success(fromUserApiToUser(response.body()!!))
    }

    override fun saveAuthToken(token: String): Unit =
        LocalStorageManager.saveString("token", token)
}