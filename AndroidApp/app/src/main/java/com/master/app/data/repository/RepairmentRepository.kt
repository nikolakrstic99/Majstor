package com.master.app.data.repository

interface RepairmentRepository {
    suspend fun getTopLevelCategories(): Resource<List<String>>
    suspend fun getCategories(topLevelCategory: String): Resource<List<String>>
}