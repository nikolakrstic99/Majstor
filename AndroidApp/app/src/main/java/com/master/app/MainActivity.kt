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
import com.master.app.ui.repairment.RepairmenSearchScreen
import com.master.app.ui.repairment.RepairmentCategoryList
import com.master.app.ui.repairment.exampleCategoryList
import com.master.app.ui.theme.AndroidAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidAppTheme {
                RepairmenSearchScreen(
                    RepairmentCategory(
                        1,
                        "Gradjevinski radovi",
                        136,
                        "pictureURL"
                    ),
                    listOf(
                        Repairman(
                            1,
                            "Milojko Pantic",
                            8.3723725,
                            listOf("Moler", "Parketar")
                        ),
                        Repairman(
                            2,
                            "Petar Vojinovic",
                            7.2,
                            listOf("Parketar")
                        ),
                        Repairman(
                            3,
                            "David Zlatkovic",
                            10.0,
                            listOf("Moler")
                        )
                    )
                )
            }
        }
    }
}