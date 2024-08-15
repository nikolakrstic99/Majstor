package com.master.app.ui.state

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.master.app.data.repository.RepairmentRepository
import com.master.app.utils.uriToBase64
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AddServiceUiState(
    val topLevelCategories: List<String>? = null,
    val categories: List<String>? = null,
    val errorMessage: String? = null
)

@HiltViewModel
class AddServiceViewModel @Inject constructor(
    private val repairmentRepository: RepairmentRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(AddServiceUiState())
    val uiState: StateFlow<AddServiceUiState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                topLevelCategories = repairmentRepository.getTopLevelCategories().data,
                categories = listOf()
            )
        }
    }

    fun topLevelCategoryChanged(topLevelCategory: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                categories = repairmentRepository.getCategories(topLevelCategory).data
            )
        }
    }

    fun addService(
        topLevelCategory: String,
        category: String,
        description: String,
        pictures: List<Uri>,
        context: Context
    ) {
        viewModelScope.launch {
            val picturesIn64 = pictures.mapNotNull { uriToBase64(context, it) }
            repairmentRepository.addService(topLevelCategory, category, description, picturesIn64)
        }
    }
}