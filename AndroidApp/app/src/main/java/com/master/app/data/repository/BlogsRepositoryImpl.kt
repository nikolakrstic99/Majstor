package com.master.app.data.repository

import com.master.app.data.entity.CreateBlogRequest
import com.master.app.data.model.Blog
import com.master.app.data.model.Image
import com.master.app.data.source.ApiService
import com.master.app.data.utils.fromBlogApiToBlog
import com.master.app.data.utils.fromImageApiToImage
import javax.inject.Inject

class BlogsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): BlogsRepository {
    override suspend fun createBlog(title: String, description: String, text: String, pictures: List<String>
    ): Resource<Blog> {
        try {
            val response = apiService.createBlog(CreateBlogRequest(title, description, text, pictures))
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

    override suspend fun getBlogImages(blogId: Int): Resource<List<Image>> {
        try {
            val response = apiService.getBlogImages(blogId)
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(response.body()!!.map { fromImageApiToImage(it) })
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

    override suspend fun deleteBlog(blogId: Int): Resource<Unit> {
        try {
            val response = apiService.deleteBlog(blogId)
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(Unit)
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }
}