package com.master.app.ui.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.master.app.data.model.Blog
import com.master.app.data.repository.BlogsRepository
import com.master.app.data.repository.BlogsRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class BlogsUiState(
    val blogs: List<Blog>? = null,
    val addedBlog: Blog? = null,
    val errorMessage: String? = null
)

class BlogsViewModel(
    private val blogsRepository: BlogsRepository = BlogsRepositoryImpl()
): ViewModel() {

    private val _uiState = MutableStateFlow(BlogsUiState())
    val uiState: StateFlow<BlogsUiState> = _uiState

    fun createBlog(title: String, description: String, text: String) {
        viewModelScope.launch {
            val blog = blogsRepository.createBlog(title, description, text)
            _uiState.value = _uiState.value.copy(
                addedBlog = blog.data,
                errorMessage = blog.message
            )
        }
    }
}