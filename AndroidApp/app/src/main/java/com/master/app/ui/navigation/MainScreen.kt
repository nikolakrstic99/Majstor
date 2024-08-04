package com.master.app.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.data.model.BlogInfo
import com.master.app.data.model.Repairman
import com.master.app.ui.blog.BlogsScreen
import com.master.app.ui.repairment.RepairmanScreen
import com.master.app.ui.theme.AndroidAppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { Sidebar() }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Repairman App") },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch { drawerState.open() }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ) { contentPadding ->
            print(contentPadding)
            BlogsScreen(
                blogs = listOf(
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
                    ),
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
                    )
                ),
                Modifier
                    .padding(top = 60.dp)
            )
//            RepairmanScreen(
//                Repairman(
//                    1,
//                    "Milojko Pantic",
//                    8.3723725,
//                    "0621482242",
//                    listOf("Moler", "Parketar")
//                )
//            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AndroidAppTheme {
        MainScreen()
    }
}