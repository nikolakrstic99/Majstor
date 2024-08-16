package com.master.app.ui.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.master.app.data.model.Blog
import com.master.app.data.model.Review
import com.master.app.data.model.Service
import com.master.app.data.model.User
import com.master.app.data.repository.BlogsRepository
import com.master.app.data.repository.RepairmentRepository
import com.master.app.data.repository.ReviewsRepository
import com.master.app.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class UserProfileUiState(
    val userInfo: User? = null,
    val reviewsOnLoggedUser: List<Int>? = null,
    val servicesByLoggedUser: List<Service>? = null,
    val blogsByLoggedUser: List<Blog>? = null,
    val errorMessage: String? = null
)

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val reviewsRepository: ReviewsRepository,
    private val repairmentRepository: RepairmentRepository,
    private val blogsRepository: BlogsRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(UserProfileUiState())
    val uiState: StateFlow<UserProfileUiState> = _uiState

    init {
        viewModelScope.launch {
            refresh()
        }
    }

    private suspend fun refresh() {
        val user = userRepository.getLoggedUser().data
        val reviews =
            if (user != null)
                reviewsRepository.getReviewsByRatedUser(user.id).data?.map { it.rating } ?: listOf()
            else
                listOf()
        val services =
            if (user != null)
                repairmentRepository.getServicesProvidedByUser(user.id).data ?: listOf()
            else
                listOf()
        val blogs =
            if (user != null)
                blogsRepository.getAllBlogs().data?.filter { it.author.id == user.id }
            else
                listOf()

        _uiState.value = _uiState.value.copy(
            userInfo = user,
            reviewsOnLoggedUser = reviews,
            servicesByLoggedUser = services,
            blogsByLoggedUser = blogs
        )
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val user = userRepository.login(email, password)
//            _uiState.value = _uiState.value.copy(
//                userInfo = user.data,
//                errorMessage = user.message
//            )
            refresh()
        }
    }

    fun register(firstName: String, lastName: String, email: String, password: String, phoneNumber: String, location: String) {
        viewModelScope.launch {
            val user = userRepository.register(firstName, lastName, email, password, phoneNumber, location)
//            _uiState.value = _uiState.value.copy(
//                userInfo = user.data,
//                errorMessage = user.message
//            )
            refresh()
        }
    }

    fun logout() {
        userRepository.logout()
        _uiState.value = _uiState.value.copy(
            userInfo = null,
            reviewsOnLoggedUser = null,
            errorMessage = null
        )
    }
}
