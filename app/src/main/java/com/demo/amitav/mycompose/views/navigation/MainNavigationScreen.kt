package com.demo.amitav.mycompose.views.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainNavigationScreen {

    @Composable
    fun NavigationScreen() {

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = NavRoutes.Home.route,
        ) {
            composable(NavRoutes.Home.route) {
                Home(navController = navController)
            }

            composable(NavRoutes.Welcome.route + "/{userName}") { backStackEntry ->
                val userName = backStackEntry.arguments?.getString("userName")
                Welcome(navController = navController, userName)
            }

            composable(NavRoutes.Profile.route) {
                Profile()
            }
        }
    }
}