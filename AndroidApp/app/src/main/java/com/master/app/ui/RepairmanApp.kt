package com.master.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.master.app.ui.blog.BlogsScreen
import com.master.app.ui.navigation.AppNavHost
import com.master.app.ui.navigation.AppNavigationActions
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navController = rememberNavController()
    val navigationActions = remember(navController) {
        AppNavigationActions(navController)
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { Sidebar(navigationActions) }
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
                    },
                )
            }
        ) { contentPadding ->
            AppNavHost(
                navigationActions = navigationActions,
                modifier = Modifier.padding(contentPadding)
            )
        }
    }
}

@Composable
fun Sidebar(
    navigationActions: AppNavigationActions,
    modifier: Modifier = Modifier
) {
    data class SidebarItemInfo(
        val title: String,
        val icon: ImageVector,
        val onClick: () -> Unit
    )

    val items = listOf(
        SidebarItemInfo(
            "Profile",
            Icons.Filled.Person,
            {}
        ),
        SidebarItemInfo(
            "Blogs",
            Icons.Filled.LocationOn,
            navigationActions::navigateToBlogsScreen
        ),
        SidebarItemInfo(
            "Repairman",
            Icons.Filled.Build,
            navigationActions::navigateToRepairmanScreen
        )
    )

    var selected by remember { mutableIntStateOf(0) }

    ModalDrawerSheet {
        for ((i, item) in items.withIndex()) {
            SidebarItem(
                title = item.title,
                icon = item.icon,
                onClick = {
                    run {
                        selected = i
                        item.onClick()
                    }
                },
                modifier
                    .clip(MaterialTheme.shapes.large)
                    .background(
                        color = if (selected == i) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.background
                    )
            )
        }
    }
}

@Composable
fun SidebarItem(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(5.dp)
            .clickable(onClick = onClick)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Leading icon"
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge
        )
    }
}