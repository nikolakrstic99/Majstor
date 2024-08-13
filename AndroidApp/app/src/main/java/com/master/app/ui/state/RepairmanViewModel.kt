package com.master.app.ui.state

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.master.app.data.model.User
import com.master.app.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RepairmanUiState(
    val repairman: User? = null,
    val errorMessage: String? = null
)

@HiltViewModel
class RepairmanViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val repairmanId: Int = savedStateHandle.get<Int>("id")!!

    private val _uiState = MutableStateFlow(RepairmanUiState())
    val uiState: StateFlow<RepairmanUiState> = _uiState

    init {
        viewModelScope.launch {
            val repairman = userRepository.getUser(repairmanId)
            _uiState.value = _uiState.value.copy(
                repairman = repairman.data,
                errorMessage = repairman.message
            )
        }
    }
}