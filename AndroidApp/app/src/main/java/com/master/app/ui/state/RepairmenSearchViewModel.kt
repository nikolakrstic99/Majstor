package com.master.app.ui.state

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.master.app.data.model.User
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
    val categoriesSelected: MutableSet<String>? = null,
    val categoriesNotSelected: MutableSet<String>? = null,
    val repairmen: Set<User>? = null,
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
            val repairmen = repairmentRepository.getUsersProvidingTopLevelCategory(topLevelCategory)

            _uiState.value = _uiState.value.copy(
                topLevelCategory = topLevelCategory,
                categoriesSelected = mutableSetOf(),
                categoriesNotSelected = categories.data?.toMutableSet(),
                repairmen = repairmen.data?.toSet(),
                message = categories.message
            )
        }
    }

    private suspend fun getRepairmen(categoriesSelected: MutableSet<String>?): Set<User> {
        var repairmen = repairmentRepository
            .getUsersProvidingTopLevelCategory(_uiState.value.topLevelCategory!!)
            .data
            ?.toMutableSet()
            ?: mutableSetOf()

        for (category in categoriesSelected ?: emptySet()) {
            val newUsers = repairmentRepository.getUsersProvidingCategory(category).data?.toSet() ?: emptySet()
            repairmen = repairmen.intersect(newUsers).toMutableSet()
        }

        return repairmen
    }

    fun categoryFilterAdded(category: String) {
        viewModelScope.launch {
            val newCategoriesSelected = _uiState.value.categoriesSelected
            newCategoriesSelected?.add(category)
            val newCategoriesNotSelected = _uiState.value.categoriesNotSelected
            newCategoriesNotSelected?.remove(category)

            _uiState.value = _uiState.value.copy(
                categoriesSelected = newCategoriesSelected,
                categoriesNotSelected = newCategoriesNotSelected,
                repairmen = getRepairmen(newCategoriesSelected)
            )
        }
    }

    fun categoryFilterRemoved(category: String) {
        viewModelScope.launch {
            val newCategoriesSelected = _uiState.value.categoriesSelected
            newCategoriesSelected?.remove(category)
            val newCategoriesNotSelected = _uiState.value.categoriesNotSelected
            newCategoriesNotSelected?.add(category)

            _uiState.value = _uiState.value.copy(
                categoriesSelected = newCategoriesSelected,
                categoriesNotSelected = newCategoriesNotSelected,
                repairmen = getRepairmen(newCategoriesSelected)
            )
        }
    }
}