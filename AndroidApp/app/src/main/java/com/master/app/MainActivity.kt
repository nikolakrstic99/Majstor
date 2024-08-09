package com.master.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.master.app.data.repository.BlogsRepository
import com.master.app.data.source.LocalStorageManager
import com.master.app.ui.MainScreen
import com.master.app.ui.state.BlogViewModel
import com.master.app.ui.theme.AndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize local storage
        LocalStorageManager.init(this)

        setContent {
            AndroidAppTheme {
                MainScreen()
            }
        }
    }
}