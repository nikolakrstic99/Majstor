package com.master.app.ui.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.master.app.data.repository.RepairmentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RepairmentCategoriesUiState(
    val topLevelCategories: List<String>? = null,
    val repairmenPerCategory: Map<String, Int>? = null,
    val message: String? = null
)

@HiltViewModel
class RepairmentCategoriesViewModel @Inject constructor(
    private val repairmentRepository: RepairmentRepository
): ViewModel()  {

    private val _uiState = MutableStateFlow(RepairmentCategoriesUiState())
    val uiState: StateFlow<RepairmentCategoriesUiState> = _uiState

    init {
        viewModelScope.launch {
            val categories = repairmentRepository.getTopLevelCategories()

            val repairmenPerCategory = HashMap<String, Int>()
            for (category in categories.data?: listOf()) {
                repairmenPerCategory[category] =
                    repairmentRepository.getUsersProvidingTopLevelCategory(category).data?.size ?: 0
            }

            _uiState.value = _uiState.value.copy(
                topLevelCategories = categories.data,
                repairmenPerCategory = repairmenPerCategory,
                message = categories.message
            )
        }
    }
}