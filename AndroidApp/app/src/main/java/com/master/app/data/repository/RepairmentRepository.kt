package com.master.app.data.repository

import com.master.app.data.model.Service
import com.master.app.data.model.ServiceImage
import com.master.app.data.model.User

interface RepairmentRepository {
    suspend fun getTopLevelCategories(): Resource<List<String>>

    suspend fun getCategories(topLevelCategory: String): Resource<List<String>>

    suspend fun addService(
        topLevelCategory: String,
        category: String,
        description: String,
        pictures: List<String>
    ): Resource<Service>

    suspend fun getUsersProvidingTopLevelCategory(topLevelCategory: String): Resource<List<User>>

    suspend fun getUsersProvidingCategory(category: String): Resource<List<User>>

    suspend fun getServicesProvidedByUser(userId: Int): Resource<List<Service>>

    suspend fun getServiceImages(serviceId: Int): Resource<List<ServiceImage>>
}