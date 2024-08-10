package com.master.app.ui.state

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.master.app.data.repository.RepairmentRepository
import com.master.app.ui.model.Repairman
import com.master.app.ui.model.RepairmentCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RepairmenSearchUiState(
    val topLevelCategory: String? = null,
    val repairmen: List<Repairman>? = null,
    val categories: List<String>? = null,
    val message: String? = null
)

@HiltViewModel
class RepairmenSearchViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repairmentRepository: RepairmentRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(RepairmenSearchUiState())
    val uiState: StateFlow<RepairmenSearchUiState> = _uiState

    init {
        viewModelScope.launch {
            val topLevelCategory: String = savedStateHandle.get<String>("topLevelCategory")!!
            val categories = repairmentRepository.getCategories(topLevelCategory)
            _uiState.value = _uiState.value.copy(
                topLevelCategory = topLevelCategory,
                categories = categories.data,
                message = categories.message
            )
        }
    }
}