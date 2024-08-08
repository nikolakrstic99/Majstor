package com.master.app.ui.user

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.master.app.ui.state.ProfileViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = viewModel()
) {
    var showLogin by remember { mutableStateOf(true) }

    Box(
        modifier = modifier
            .padding(start = 10.dp, end = 10.dp)
    ) {
        // If not logged in
        if (showLogin) {
            Login(
                onSubmit = { /*TODO*/ },
                onSignUpClicked = { showLogin = false }
            )
        }
        else {
            Register(
                onSubmit = { /*TODO*/ },
                onSignInClicked = { showLogin = true }
            )
        }

        // If logged in
    }
}