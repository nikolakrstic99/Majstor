package com.master.app.ui.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.master.app.data.model.Blog
import com.master.app.data.repository.BlogsRepository
import com.master.app.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class BlogsUiState(
    val blogs: List<Blog>? = null,
    val addedBlog: Blog? = null,
    val isUserLoggedIn: Boolean = false,
    val errorMessage: String? = null
)

@HiltViewModel
class BlogsViewModel @Inject constructor(
    private val blogsRepository: BlogsRepository,
    private val userRepository: UserRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(BlogsUiState())
    val uiState: StateFlow<BlogsUiState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                isUserLoggedIn = userRepository.isUserLoggedIn(),
                blogs = blogsRepository.getAllBlogs().data
            )
        }
    }

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