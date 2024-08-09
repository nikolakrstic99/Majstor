package com.master.app.ui.user

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.master.app.ui.state.UserViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var showLogin by remember { mutableStateOf(true) }

    Box(
        modifier = modifier
            .padding(start = 10.dp, end = 10.dp)
    ) {
        if (uiState.userInfo == null) {
            // User is not logged in
            if (showLogin) {
                Login(
                    onSubmit = viewModel::login,
                    onSignUpClicked = { showLogin = false }
                )
            }
            else {
                Register(
                    onSubmit = viewModel::register,
                    onSignInClicked = { showLogin = true }
                )
            }
        }
        else {
            // User is logged in
            Text(text = "ulogovan ${uiState.userInfo?.email}")
        }
    }
}