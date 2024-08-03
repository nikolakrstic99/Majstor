package com.master.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.master.app.data.model.Blog
import com.master.app.data.model.BlogInfo
import com.master.app.data.model.Repairman
import com.master.app.data.model.RepairmentCategory
import com.master.app.ui.blog.BlogPreview
import com.master.app.ui.blog.BlogScreen
import com.master.app.ui.navigation.MainScreen
import com.master.app.ui.repairment.RepairmanScreen
import com.master.app.ui.repairment.RepairmenSearchScreen
import com.master.app.ui.repairment.RepairmentCategoryList
import com.master.app.ui.repairment.exampleCategoryList
import com.master.app.ui.theme.AndroidAppTheme
import com.master.app.ui.user.Login

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidAppTheme {
                MainScreen()
            }
        }
    }
}