package com.master.app.ui.blog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.ui.state.BlogsViewModel
import com.master.app.ui.theme.AndroidAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BlogsScreen(
    onNavigateToBlogScreen: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: BlogsViewModel = viewModel(),
) {
    var showAddBlogDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Add story") },
                icon = {
                    Icon(
                        Icons.Filled.AddCircle,
                        contentDescription = "Add story"
                    )
                },
                onClick = { showAddBlogDialog = true }
            )
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
                    items = viewModel.blogs
                ) {
                    BlogPreview(
                        blog = it,
                        Modifier
                            .size(width = 500.dp, height = 150.dp)
                            .clickable(onClick = {
                                onNavigateToBlogScreen(it.id)
                            })
                    )
                    Divider()
                }
            }
            if (showAddBlogDialog) {
                AddBlogDialog(
                    onSubmit = {
                        run {
                            showAddBlogDialog = false
                            /* SEND REQUEST */
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