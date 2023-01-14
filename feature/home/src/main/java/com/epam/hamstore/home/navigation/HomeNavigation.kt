package com.epam.hamstore.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.epam.hamstore.home.HomeRoute

const val homeScreenRoute = "home_screen_route"

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    navigate(route = homeScreenRoute, navOptions = navOptions)
}

fun NavGraphBuilder.homeScreen() {
    composable(route = homeScreenRoute) {
        HomeRoute()
    }
}