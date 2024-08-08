package com.master.app.ui.state

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.master.app.data.model.LoginRequest
import com.master.app.data.repository.UserRepository
import com.master.app.data.repository.UserRepositoryImpl
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserRepository = UserRepositoryImpl()
): ViewModel() {

    fun login() {
        viewModelScope.launch {
            val response = userRepository.login(LoginRequest("nikolakrstic99@gmail.com", "nikola123"))
            if (response.isSuccessful) {
                response.body()
            }
        }
    }
}