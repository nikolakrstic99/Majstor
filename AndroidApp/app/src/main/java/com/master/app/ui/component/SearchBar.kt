package com.master.app.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun SearchBar(
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Search"
) {
    var textInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = textInput,
        onValueChange = { input ->
            run {
                textInput = input
                onValueChanged(input)
            }
        },
        placeholder = { Text(text = placeholder) },
        shape = RoundedCornerShape(25.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search for item"
            )
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    AndroidAppTheme {
        SearchBar({})
    }
}