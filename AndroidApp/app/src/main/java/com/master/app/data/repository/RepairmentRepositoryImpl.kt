package com.master.app.data.repository

import com.master.app.data.source.ApiService
import javax.inject.Inject

class RepairmentRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): RepairmentRepository {

    override suspend fun getTopLevelCategories(): Resource<List<String>> {
        try {
            val response = apiService.getTopLevelCategories()
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(response.body()!!)
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

    override suspend fun getCategories(topLevelCategory: String): Resource<List<String>> {
        try {
            val response = apiService.getCategories(topLevelCategory)
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(response.body()!!)
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }
}