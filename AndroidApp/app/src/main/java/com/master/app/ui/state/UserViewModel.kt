package com.master.app.ui.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.master.app.data.model.User
import com.master.app.data.repository.RepairmentRepository
import com.master.app.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class UserProfileUiState(
    val userInfo: User? = null,
    val errorMessage: String? = null
)

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(UserProfileUiState())
    val uiState: StateFlow<UserProfileUiState> = _uiState

    init {
        viewModelScope.launch {
            val user = userRepository.getLoggedUser()
            _uiState.value = _uiState.value.copy(
                userInfo = user.data,
                errorMessage = user.message
            )
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val user = userRepository.login(email, password)
            _uiState.value = _uiState.value.copy(
                userInfo = user.data,
                errorMessage = user.message
            )
        }
    }

    fun register(firstName: String, lastName: String, email: String, password: String) {
        viewModelScope.launch {
            val user = userRepository.register(firstName, lastName, email, password)
            _uiState.value = _uiState.value.copy(
                userInfo = user.data,
                errorMessage = user.message
            )
        }
    }
}
