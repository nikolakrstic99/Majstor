package com.master.app.ui.state

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.master.app.data.model.Review
import com.master.app.data.model.Service
import com.master.app.data.model.User
import com.master.app.data.repository.RepairmentRepository
import com.master.app.data.repository.ReviewsRepository
import com.master.app.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RepairmanUiState(
    val loggedUser: User? = null,
    val repairman: User? = null,
    val reviews: List<Review>? = null,
    val averageRating: Double? = null,
    val showReviewRepairmenButton: Boolean = false,
    val services: List<Service>? = null,
    val errorMessage: String? = null
)

@HiltViewModel
class RepairmanViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val reviewsRepository: ReviewsRepository,
    private val repairmentRepository: RepairmentRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val repairmanId: Int = savedStateHandle.get<Int>("id")!!

    private val _uiState = MutableStateFlow(RepairmanUiState())
    val uiState: StateFlow<RepairmanUiState> = _uiState

    init {
        viewModelScope.launch {
            val loggedUser = userRepository.getLoggedUser()
            val repairman = userRepository.getUser(repairmanId)
            val services = repairmentRepository.getServicesProvidedByUser(repairmanId)

            _uiState.value = _uiState.value.copy(
                loggedUser = loggedUser.data,
                repairman = repairman.data,
                services = services.data,
                errorMessage = repairman.message
            )

            refreshReviews()
        }
    }

    private fun canLoggedUserReviewRepairman(reviews: List<Review>?): Boolean {
        return uiState.value.loggedUser != null && uiState.value.repairman != null
                && uiState.value.loggedUser!!.id != uiState.value.repairman!!.id
                && reviews?.none { it.creatorUser.id == uiState.value.loggedUser!!.id } == true
    }

    private suspend fun refreshReviews() {
        val reviews = reviewsRepository.getReviewsByRatedUser(repairmanId)
        val avgRating = reviews.data?.map { it.rating }?.average()

        _uiState.value = _uiState.value.copy(
            reviews = reviews.data,
            averageRating = avgRating,
            showReviewRepairmenButton = canLoggedUserReviewRepairman(reviews.data),
            errorMessage = reviews.message
        )
    }

    fun addReview(text: String, rating: Int) {
        viewModelScope.launch {
            reviewsRepository.addReview(repairmanId, text, rating)
            refreshReviews()
        }
    }
}