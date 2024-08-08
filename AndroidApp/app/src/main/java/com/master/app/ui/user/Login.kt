package com.master.app.ui.user

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.ui.component.ClippedIconButton
import com.master.app.ui.component.PasswordTextField
import com.master.app.ui.theme.AndroidAppTheme
import com.master.app.utils.isEmailValid
import com.master.app.utils.isPasswordValid

@Composable
fun Login(
    onSubmit: (String, String) -> Unit,
    onSignUpClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.onPrimary)
                .border(
                    1.0.dp,
                    Color.Gray,
                    MaterialTheme.shapes.small
                )
                .padding(50.dp)
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Divider()
            OutlinedTextField(
                value = email,
                onValueChange = { input -> email = input},
                placeholder = { Text(text = "Email") },
                maxLines = 1,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
            )
            PasswordTextField(
                onValueChanged = { input -> password = input },
                placeholder = "Password"
            )
            ClippedIconButton(
                text = "Login",
                onClick = { onSubmit(email, password) },
                modifier = Modifier.size(200.dp, 50.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.onPrimary)
                .border(
                    1.0.dp,
                    Color.Gray,
                    MaterialTheme.shapes.small
                )
                .padding(30.dp)
        ) {
            Text(text = "Don't have an account?")
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Sign up",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable(onClick = onSignUpClicked)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    AndroidAppTheme {
        Login({_, _ -> }, {})
    }
}