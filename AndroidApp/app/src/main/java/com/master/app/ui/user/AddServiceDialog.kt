package com.master.app.ui.user

import android.Manifest
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.master.app.ui.component.ClippedIconButton
import com.master.app.ui.component.DropdownSelectMenu
import com.master.app.ui.state.AddServiceViewModel
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun AddServiceDialog(
    onSubmit: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AddServiceViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    var topLevelCategory by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var pictures by remember { mutableStateOf<List<Uri>>(emptyList()) }

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetMultipleContents()
    ) { uris ->
        pictures = uris
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions.entries.all { it.value }
        if (granted) {
            galleryLauncher.launch("image/*")
        }
    }

    Dialog(onDismissRequest = onDismiss) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .padding(15.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(2f))
                Text(
                    text = "Add new service",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = onDismiss) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close dialog"
                    )
                }
            }
            DropdownSelectMenu(
                title = "Top level category",
                options = uiState.topLevelCategories?: listOf(),
                selectedOption = topLevelCategory,
                onOptionSelected = {
                    topLevelCategory = it
                    category = ""
                    viewModel.topLevelCategoryChanged(it)
                }
            )
            DropdownSelectMenu(
                title = "Category",
                options = uiState.categories?: listOf(),
                selectedOption = category,
                onOptionSelected = {
                    category = it
                }
            )
            OutlinedTextField(
                value = description,
                onValueChange = { input -> description = input},
                placeholder = { Text(text = "Short description") },
                maxLines = 5,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        1.5.dp,
                        MaterialTheme.colorScheme.tertiary,
                        MaterialTheme.shapes.small
                    )
                    .background(MaterialTheme.colorScheme.background)
                    .padding(10.dp)
                    .clickable {
                        permissionLauncher.launch(
                            arrayOf(Manifest.permission.READ_MEDIA_IMAGES)
                        )
                    }
            ) {
                Icon(
                    imageVector = Icons.Filled.AddCircle,
                    contentDescription = "Add pictures"
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Upload pictures",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
            if (topLevelCategory.isNotBlank()
                && description.isNotBlank()
                && category.isNotBlank())
            {
                ClippedIconButton(
                    text = "Add",
                    onClick = {
                        onSubmit()
                        viewModel.addService(
                            topLevelCategory,
                            category,
                            description,
                            pictures
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddServiceDialogPreview() {
    AndroidAppTheme {
        AddServiceDialog(onSubmit = { }, onDismiss = { })
    }
}