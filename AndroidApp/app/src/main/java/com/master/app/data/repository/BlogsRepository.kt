package com.master.app.data.repository

import com.master.app.data.model.Blog
import com.master.app.data.model.Image
import com.master.app.data.model.User

interface BlogsRepository {
    suspend fun createBlog(title: String, description: String, text: String, pictures: List<String>):
            Resource<Blog>
    suspend fun getAllBlogs(): Resource<List<Blog>>
    suspend fun getBlogImages(blogId: Int): Resource<List<Image>>
    suspend fun deleteBlog(blogId: Int): Resource<Unit>
}