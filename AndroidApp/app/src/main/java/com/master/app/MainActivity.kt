package com.master.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.master.app.data.model.BlogInfo
import com.master.app.ui.compose.blog.BlogPreview
import com.master.app.ui.theme.AndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidAppTheme {
                BlogPreview(blog = BlogInfo(1, "title", "description", "picture", "10min ago", "Andrej Jokic"))
            }
        }
    }
}