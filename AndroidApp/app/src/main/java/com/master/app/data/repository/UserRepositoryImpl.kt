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
        try {
            val response = RetrofitInstance.api.login(LoginRequest(email, password))
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }

            // Save auth token
            saveAuthToken(response.body()!!.token!!)

            return Resource.Success(fromUserApiToUser(response.body()!!))
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

    override suspend fun register(firstName: String, lastName: String, email: String, password: String
    ): Resource<User> {
        try {
            val response = RetrofitInstance.api.register(RegisterRequest(
                firstName = firstName,
                lastName = lastName,
                email = email,
                password = password
            ))
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }

            // Save auth token
            saveAuthToken(response.body()!!.token!!)

            return Resource.Success(fromUserApiToUser(response.body()!!))
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

    override suspend fun getLoggedUser(): Resource<User> {
        if (!hasAuthToken()) {
            return Resource.Error("No JWT token")
        }
        try {
            val response = RetrofitInstance.api.getLoggedUser()
            if (!response.isSuccessful) {
                // Token may have expired, so delete it
                deleteAuthToken()
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(fromUserApiToUser(response.body()!!))
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }

    }

    override suspend fun isUserLoggedIn(): Boolean {
        if (!hasAuthToken()) {
            return false
        }
        return try {
            RetrofitInstance.api.getLoggedUser().isSuccessful
        } catch (e: Exception) {
            false
        }
    }

    private fun saveAuthToken(token: String) = LocalStorageManager.saveString("token", token)
    private fun hasAuthToken(): Boolean = LocalStorageManager.contains("token")
    private fun deleteAuthToken() = LocalStorageManager.deleteString("token")
}