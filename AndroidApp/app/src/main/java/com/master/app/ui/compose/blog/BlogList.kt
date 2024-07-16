package com.master.app.ui.compose.blog

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.master.app.data.model.BlogInfo
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun BlogList(
    blogs: List<BlogInfo>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(
            items = blogs
        ) {
            BlogPreview(blog = it)
            Divider(color = MaterialTheme.colorScheme.primary)
        }
    }
}

val exampleBlogList = listOf(
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

@Preview(showBackground = true)
@Composable
fun BlogListPreview() {
    AndroidAppTheme {
        BlogList(blogs = exampleBlogList)
    }
}