package com.master.app.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.master.app.data.model.Repairman
import com.master.app.ui.blog.BlogScreen
import com.master.app.ui.blog.BlogsScreen
import com.master.app.ui.repairment.RepairmanScreen
import com.master.app.ui.state.BlogViewModel

object NavigationRoute {
    const val BLOGS = "Blogs"
    const val BLOG = "Blog"
    const val REPAIRMAN = "Repairman"
}

class AppNavigationActions(val navController: NavHostController) {
    fun navigateToBlogScreen(blogId: Int) {
        navController.navigate("${NavigationRoute.BLOG}/$blogId")
    }

    fun navigateToBlogsScreen() {
        navController.navigate(NavigationRoute.BLOGS)
    }

    fun navigateToRepairmanScreen() {
        navController.navigate(NavigationRoute.REPAIRMAN)
    }
}

@Composable
fun AppNavHost(
    navigationActions: AppNavigationActions,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navigationActions.navController,
        startDestination = NavigationRoute.REPAIRMAN
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
        ) {backStackEntry ->
            val blogId = backStackEntry.arguments?.getInt("id")!!
            BlogScreen(
                viewModel = BlogViewModel(blogId),
                modifier = modifier
            )
        }
        composable(
            route = NavigationRoute.REPAIRMAN
        ) {
            RepairmanScreen(
                repairman = Repairman(
                    1,
                    "Milojko Pantic",
                    8.3723725,
                    "0621482242",
                    listOf("Moler", "Parketar")
                ),
                modifier
            )
        }
    }
}