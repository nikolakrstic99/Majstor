package com.master.app.ui.user

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun UserProfile(
    modifier: Modifier = Modifier
) {
}

@Preview(showBackground = true)
@Composable
fun UserProfilePreview() {
    AndroidAppTheme {
        UserProfile()
    }
}