package com.master.app.ui.blog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.master.app.ui.state.BlogsViewModel
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun BlogsScreen(
    onNavigateToBlogScreen: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: BlogsViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        // We need to refresh here in case we get here
        // by deleting the blog.
        viewModel.refresh()
    }

    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()
    var showAddBlogDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            if (uiState.isUserLoggedIn) {
                ExtendedFloatingActionButton(
                    text = { Text("Add story") },
                    icon = {
                        Icon(
                            Icons.Filled.AddCircle,
                            contentDescription = "Add story"
                        )
                    },
                    onClick = { showAddBlogDialog = true },
                )
            }
        }
    ) { contentPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .padding(contentPadding)
                .padding(10.dp)
        ) {
            // Necessary because scaffold inside a scaffold
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Repairman stories",
                style = MaterialTheme.typography.displaySmall,
                maxLines = 1
            )
            Divider()
            LazyColumn {
                items(
                    items = uiState.blogs?: listOf()
                ) {
                    Box(
                        modifier = Modifier.clickable(onClick = { onNavigateToBlogScreen(it.id) })
                    ) {
                        BlogPreview(
                            blog = it,
                            Modifier.size(width = 500.dp, height = 150.dp)
                        )
                    }
                    Divider()
                }
            }
            if (showAddBlogDialog) {
                AddBlogDialog(
                    onSubmit = { title, description, text, pictures ->
                        run {
                            showAddBlogDialog = false
                            viewModel.createBlog(title, description, text, pictures, context)
                        }
                    },
                    onDismiss = { showAddBlogDialog = false }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BlogsScreenPreview() {
    AndroidAppTheme {
        BlogsScreen({})
    }
}