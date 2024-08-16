package com.master.app.ui.state

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.master.app.data.model.Blog
import com.master.app.data.repository.BlogsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class BlogUiState(
    val blog: Blog? = null
)

@HiltViewModel
class BlogViewModel @Inject constructor(
    private val blogsRepository: BlogsRepository,
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {

    // Get blogId set by compose navigation
    private val blogId: Int = savedStateHandle.get<Int>("id")!!

    private val _uiState = MutableStateFlow(BlogUiState())
    val uiState: StateFlow<BlogUiState> = _uiState

    init {
        viewModelScope.launch {
            val blog = blogsRepository.getAllBlogs().data
                ?.find { it.id == blogId }
                ?.copy(
                    images = blogsRepository.getBlogImages(blogId).data ?: listOf()
                )

            _uiState.value = _uiState.value.copy(
                blog = blog
            )
        }
    }
}