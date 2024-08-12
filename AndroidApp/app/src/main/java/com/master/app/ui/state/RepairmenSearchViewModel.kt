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
    val categoriesSelected: Set<String>? = null,
    val categoriesNotSelected: Set<String>? = null,
    internal val allRepairmen: List<User>? = null,   // All repairmen
    val repairmen: List<User> = listOf(),           // Repairmen to show
    val sortByNameAsc: Boolean = true,
    val sortByRatingAsc: Boolean = false,
    val searchText: String = "",
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
            val allRepairmen = repairmentRepository.getUsersProvidingTopLevelCategory(topLevelCategory)

            _uiState.value = _uiState.value.copy(
                topLevelCategory = topLevelCategory,
                categoriesSelected = setOf(),
                categoriesNotSelected = categories.data?.toSet(),
                allRepairmen = allRepairmen.data,
                repairmen = sortRepairmen(
                    allRepairmen.data ?: listOf(),
                    uiState.value.sortByNameAsc,
                    uiState.value.sortByRatingAsc
                ),
                message = categories.message
            )
        }
    }

    // Always first sort by rating and then by name
    private fun sortRepairmen(
        repairmen: List<User>,
        sortByNameAsc: Boolean,
        sortByRatingAsc: Boolean
    ): List<User> {
        val sortedRepairmen = repairmen.toMutableList()

        // Sort by rating
        if (sortByRatingAsc)
            sortedRepairmen.sortBy { it.rating }
        else
            sortedRepairmen.sortByDescending { it.rating }

        // Sort by name
        if (sortByNameAsc)
            sortedRepairmen.sortBy { it.firstName + it.lastName }
        else
            sortedRepairmen.sortByDescending { it.firstName + it.lastName }

        return sortedRepairmen
    }

    private fun filterBySearchText(repairmen: List<User>, prefix: String): List<User> {
        return repairmen.toMutableList().filter {
            it.firstName.startsWith(prefix)
                    || it.lastName.startsWith(prefix)
                    || (it.firstName + " " + it.lastName).startsWith(prefix)
        }
    }

    private suspend fun filterByCategories(
        repairmen: List<User>,
        categoriesSelected: Set<String>?
    ): List<User> {

        var matchedRepairmen = repairmen.toMutableSet()

        for (category in categoriesSelected ?: emptySet()) {
            val newUsers = repairmentRepository.getUsersProvidingCategory(category).data?.toSet() ?: emptySet()
            matchedRepairmen = matchedRepairmen.intersect(newUsers).toMutableSet()
        }

        return matchedRepairmen.toList()
    }

    fun categoryFilterAdded(category: String) {
        viewModelScope.launch {
            val newCategoriesSelected = uiState.value.categoriesSelected?.toMutableSet()?.apply {
                add(category)
            }
            val newCategoriesNotSelected = uiState.value.categoriesNotSelected?.toMutableSet()?.apply {
                remove(category)
            }
            val repairmen = sortRepairmen(
                filterByCategories(
                    uiState.value.repairmen,
                    newCategoriesSelected
                ),
                uiState.value.sortByNameAsc,
                uiState.value.sortByRatingAsc
            )

            _uiState.value = _uiState.value.copy(
                categoriesSelected = newCategoriesSelected,
                categoriesNotSelected = newCategoriesNotSelected,
                repairmen = repairmen
            )
        }
    }

    fun categoryFilterRemoved(category: String) {
        viewModelScope.launch {
            val newCategoriesSelected = _uiState.value.categoriesSelected?.toMutableSet()?.apply {
                remove(category)
            }
            val newCategoriesNotSelected = _uiState.value.categoriesNotSelected?.toMutableSet()?.apply {
                add(category)
            }
            val repairmen = sortRepairmen(
                filterByCategories(
                    filterBySearchText(
                        uiState.value.allRepairmen ?: listOf(),
                        uiState.value.searchText
                    ),
                    newCategoriesSelected
                ),
                uiState.value.sortByNameAsc,
                uiState.value.sortByRatingAsc
            )

            _uiState.value = _uiState.value.copy(
                categoriesSelected = newCategoriesSelected,
                categoriesNotSelected = newCategoriesNotSelected,
                repairmen = repairmen
            )
        }
    }

    fun onSortByRatingClicked() {
        val sortByRatingAsc = !uiState.value.sortByRatingAsc
        val repairmen = sortRepairmen(
            uiState.value.repairmen,
            uiState.value.sortByNameAsc,
            sortByRatingAsc
        )

        _uiState.value = _uiState.value.copy(
            repairmen = repairmen,
            sortByRatingAsc = sortByRatingAsc
        )
    }

    fun onSortByNameClicked() {
        val sortByNameAsc = !uiState.value.sortByNameAsc
        val repairmen = sortRepairmen(
            uiState.value.repairmen,
            sortByNameAsc,
            uiState.value.sortByRatingAsc
        )

        _uiState.value = _uiState.value.copy(
            repairmen = repairmen,
            sortByNameAsc = sortByNameAsc
        )
    }

    fun onSearchInputChanged(searchText: String) {
        val repairmen = sortRepairmen(
            filterBySearchText(
                uiState.value.allRepairmen ?: listOf(),
                searchText
            ),
            uiState.value.sortByNameAsc,
            uiState.value.sortByRatingAsc
        )
        _uiState.value = _uiState.value.copy(
            repairmen = repairmen,
            searchText = searchText
        )
    }
}