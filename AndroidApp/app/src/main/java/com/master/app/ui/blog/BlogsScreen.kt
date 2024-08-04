package com.master.app.ui.blog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.master.app.data.model.BlogInfo
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun BlogsScreen(
    blogs: List<BlogInfo>,
    modifier: Modifier = Modifier
) {
    var showAddBlogDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Add blog") },
                icon = {
                    Icon(
                        Icons.Filled.AddCircle,
                        contentDescription = "Add blog"
                    )
                },
                onClick = { showAddBlogDialog = true }
            )
        }
    ) { contentPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier
                .padding(contentPadding)
                .padding(10.dp)
        ) {
            Text(
                text = "Repairman stories",
                style = MaterialTheme.typography.displaySmall,
                maxLines = 1
            )
            Divider()
            LazyColumn {
                items(
                    items = blogs
                ) {
                    BlogPreview(
                        blog = it,
                        Modifier
                            .size(width = 500.dp, height = 150.dp)
                            .clickable(onClick = { print("gas") })
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
        BlogsScreen(
            listOf(
                BlogInfo(
                    1,
                    "A Breakdown of the Full English Breakfast",
                    "Welcome to Weekend Brunch! Skip the lines and make brunch at home. The coffee’s truly bottomless and the best part is PJs all the way! This week: a guide to the gloriousness that is known as A Full English Breakfast.",
                    "picture",
                    "01.04.2024",
                    "Andrej Jokic"
                ),
                BlogInfo(
                    2,
                    "Tiktok Baked Feta Pasta",
                    "This tiktok pasta has it all, big bold flavors, creamy comfort, and carbs!",
                    "picture",
                    "05.10.2024",
                    "Nikola Krstic"
                ),
                BlogInfo(
                    3,
                    "Mixed Fish Sauce Recipe",
                    "Everything you ever wanted to know about fish sauce, plus my secret recipe for the best fish sauce you’ve ever had.",
                    "picture",
                    "12.11.2024",
                    "Sara Kolarevic"
                )
            )
        )
    }
}