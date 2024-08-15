package com.master.app.data.repository

import com.master.app.data.entity.AddServiceRequest
import com.master.app.data.model.Service
import com.master.app.data.model.ServiceImage
import com.master.app.data.model.User
import com.master.app.data.source.ApiService
import com.master.app.data.utils.fromServiceApiToService
import com.master.app.data.utils.fromServiceImageApiToService
import com.master.app.data.utils.fromUserApiToUser
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

    override suspend fun addService(
        topLevelCategory: String,
        category: String,
        description: String,
        pictures: List<String>
    ): Resource<Service> {
        try {
            val response = apiService.addService(
                AddServiceRequest(topLevelCategory, category, description, pictures)
            )
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(fromServiceApiToService(response.body()!!))
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

    override suspend fun getUsersProvidingTopLevelCategory(topLevelCategory: String): Resource<List<User>> {
        try {
            val response = apiService.getUsersProvidingL1Category(topLevelCategory)
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(response.body()!!.map { fromUserApiToUser(it.user) })
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

    override suspend fun getUsersProvidingCategory(category: String): Resource<List<User>> {
        try {
            val response = apiService.getUsersProvidingL2Category(category)
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(response.body()!!.map { fromUserApiToUser(it.user) })
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

    override suspend fun getServicesProvidedByUser(userId: Int): Resource<List<Service>> {
        try {
            val response = apiService.getServicesProvidedByUser(userId)
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(response.body()!!.map { fromServiceApiToService(it) })
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

    override suspend fun getServiceImages(serviceId: Int): Resource<List<ServiceImage>> {
        try {
            val response = apiService.getServiceImages(serviceId)
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(response.body()!!.map { fromServiceImageApiToService(it) })
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }
}