package com.master.app.data.repository

import com.master.app.data.entity.CreateBlogRequest
import com.master.app.data.model.Blog
import com.master.app.data.source.ApiService
import com.master.app.data.utils.fromBlogApiToBlog
import javax.inject.Inject

class BlogsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): BlogsRepository {
    override suspend fun createBlog(title: String, description: String, text: String
    ): Resource<Blog> {
        try {
            val response = apiService.createBlog(CreateBlogRequest(title, description, text))
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(fromBlogApiToBlog(response.body()!!))
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

    override suspend fun getAllBlogs(): Resource<List<Blog>> {
        try {
            val response = apiService.getAllBlogs()
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(response.body()!!.map {
                fromBlogApiToBlog(it)
            })
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }
}