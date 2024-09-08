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
    val latestReviewsOnLoggedUser: List<Review>? = null,
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
            _refresh()
        }
    }

    private suspend fun _refresh() {
        val user = userRepository.getLoggedUser().data
        val reviews =
            if (user != null)
                reviewsRepository.getReviewsByRatedUser(user.id).data?.map { it.rating } ?: listOf()
            else
                listOf()
        val services =
            if (user != null)
                repairmentRepository.getServicesProvidedByUser(user.id).data
                    ?.map {
                        val images = repairmentRepository.getServiceImages(it.id).data ?: listOf()
                        it.copy(
                            images = images
                        )
                    }
                    ?: listOf()
            else
                listOf()
        val blogs =
            if (user != null)
                blogsRepository.getAllBlogs().data
                    ?.filter { it.author.id == user.id }
                    ?.map {
                        val images = blogsRepository.getBlogImages(it.id).data ?: listOf()
                        it.copy(
                            images = images
                        )
                    }
            else
                listOf()
        val reviewsOnLoggedUser =
            if (user != null)
                reviewsRepository.getReviewsByRatedUser(user.id).data
                    ?.sortedByDescending { it.id }
                    ?.take(3)
                    ?: listOf()
            else
                listOf()

        _uiState.value = _uiState.value.copy(
            userInfo = user,
            reviewsOnLoggedUser = reviews,
            servicesByLoggedUser = services,
            blogsByLoggedUser = blogs,
            latestReviewsOnLoggedUser = reviewsOnLoggedUser
        )
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val user = userRepository.login(email, password)
            _refresh()
        }
    }

    fun register(firstName: String, lastName: String, email: String, password: String, phoneNumber: String, location: String) {
        viewModelScope.launch {
            val user = userRepository.register(firstName, lastName, email, password, phoneNumber, location)
            _refresh()
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

    fun refresh() {
        viewModelScope.launch {
            _refresh()
        }
    }

    fun deleteService(serviceId: Int) {
        viewModelScope.launch {
            repairmentRepository.deleteService(serviceId)
            _refresh()
        }
    }
}
