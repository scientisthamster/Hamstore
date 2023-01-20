package com.epam.hamstore.basket.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.epam.hamstore.basket.BasketRoute

const val basketScreenRoute = "basket_screen_route"

fun NavController.navigateToBasket(navOptions: NavOptions? = null) {
    navigate(route = basketScreenRoute, navOptions = navOptions)
}

fun NavGraphBuilder.basketScreen() {
    composable(route = basketScreenRoute) {
        BasketRoute()
    }
}