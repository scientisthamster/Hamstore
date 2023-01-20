package com.epam.hamstore.category

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val categoryScreenRoute = "category_screen_route"

fun NavController.navigateToCategory(navOptions: NavOptions? = null) {
    navigate(route = categoryScreenRoute, navOptions = navOptions)
}

fun NavGraphBuilder.categoryScreen() {
    composable(route = categoryScreenRoute) {
        CategoryRoute()
    }
}