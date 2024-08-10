package com.master.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.master.app.ui.blog.BlogScreen
import com.master.app.ui.blog.BlogsScreen
import com.master.app.ui.repairment.RepairmanScreen
import com.master.app.ui.repairment.RepairmenSearchScreen
import com.master.app.ui.repairment.RepairmentCategoryList
import com.master.app.ui.state.BlogViewModel
import com.master.app.ui.state.BlogsViewModel
import com.master.app.ui.state.UserViewModel
import com.master.app.ui.state.RepairmanViewModel
import com.master.app.ui.state.RepairmenSearchViewModel
import com.master.app.ui.state.RepairmentCategoriesViewModel
import com.master.app.ui.user.ProfileScreen

object NavigationRoute {
    const val BLOGS = "Blogs"
    const val BLOG = "Blog"
    const val REPAIRMAN = "Repairman"
    const val REPAIRMENT_CATEGORIES = "RepairmentCategories"
    const val REPAIRMEN_SEARCH = "RepairmenSearch"
    const val PROFILE = "Profile"
}

class AppNavigationActions(val navController: NavHostController) {
    fun navigateToBlogScreen(blogId: Int) {
        navController.navigate("${NavigationRoute.BLOG}/$blogId")
    }

    fun navigateToBlogsScreen() {
        navController.navigate(NavigationRoute.BLOGS)
    }

    fun navigateToRepairmentCategoriesScreen() {
        navController.navigate(NavigationRoute.REPAIRMENT_CATEGORIES)
    }

    fun navigateToRepairmenSearchScreen(topLevelCategory: String) {
        navController.navigate("${NavigationRoute.REPAIRMEN_SEARCH}/$topLevelCategory")
    }

    fun navigateToRepairmanScreen(repairmanId: Int) {
        navController.navigate("${NavigationRoute.REPAIRMAN}/$repairmanId")
    }

    fun navigateToProfileScreen() {
        navController.navigate(NavigationRoute.PROFILE)
    }
}

@Composable
fun AppNavHost(
    navigationActions: AppNavigationActions,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navigationActions.navController,
        startDestination = NavigationRoute.PROFILE
    ) {
        composable(route = NavigationRoute.BLOGS) {
            BlogsScreen(
                onNavigateToBlogScreen = navigationActions::navigateToBlogScreen,
                modifier = modifier
            )
        }
        composable(
            route = "${NavigationRoute.BLOG}/{id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                }
            )
        ) {
            BlogScreen(
                modifier = modifier
            )
        }
        composable(route = NavigationRoute.REPAIRMENT_CATEGORIES) {
            RepairmentCategoryList(
                onCategoryClicked = navigationActions::navigateToRepairmenSearchScreen,
                modifier = modifier
            )
        }
        composable(
            route = "${NavigationRoute.REPAIRMEN_SEARCH}/{topLevelCategory}",
            arguments = listOf(
                navArgument(name = "topLevelCategory") {
                    type = NavType.StringType
                }
            )
        ) {
            RepairmenSearchScreen(
                onRepairmanClicked = navigationActions::navigateToRepairmanScreen,
                modifier = modifier
            )
        }
        composable(
            route = "${NavigationRoute.REPAIRMAN}/{id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                }
            )
        ) {
            RepairmanScreen(
                viewModel = viewModel<RepairmanViewModel>(),
                modifier = modifier
            )
        }
        composable(route = NavigationRoute.PROFILE) {
            ProfileScreen(
                modifier = modifier
            )
        }
    }
}