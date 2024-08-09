package com.master.app.data.repository

import com.master.app.data.entity.CreateBlogRequest
import com.master.app.data.model.Blog
import com.master.app.data.source.RetrofitInstance
import com.master.app.data.utils.fromBlogApiToBlog

class BlogsRepositoryImpl: BlogsRepository {
    override suspend fun createBlog(title: String, description: String, text: String
    ): Resource<Blog> {
        try {
            val response = RetrofitInstance.api.createBlog(CreateBlogRequest(title, description, text))
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(fromBlogApiToBlog(response.body()!!))
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }
}