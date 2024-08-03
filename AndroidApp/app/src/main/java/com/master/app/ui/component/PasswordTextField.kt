package com.master.app.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.R
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun PasswordTextField(
    onValueChanged: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { input ->
            run {
                password = input
                onValueChanged(password)
            }
        },
        placeholder = { Text(text = placeholder) },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Image(
                    painter = if (passwordVisible)
                        painterResource(id = R.drawable.visibility)
                    else
                        painterResource(id = R.drawable.visibility_off),
                    contentDescription = "Visibility",
                    modifier = Modifier.size(15.dp)
                )
            }
        },
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    AndroidAppTheme {
        PasswordTextField({input -> }, "placehorder")
    }
}