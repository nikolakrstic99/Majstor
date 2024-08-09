package com.master.app.data.repository

import com.master.app.data.model.Blog
import com.master.app.data.model.User

interface BlogsRepository {
    suspend fun createBlog(title: String, description: String, text: String): Resource<Blog>
}