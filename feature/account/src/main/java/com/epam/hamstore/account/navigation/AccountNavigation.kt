package com.epam.hamstore.account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.epam.hamstore.account.AccountScreen

const val accountScreenRoute = "account_screen_route"

fun NavController.navigateToAccount(navOptions: NavOptions? = null) {
    navigate(route = accountScreenRoute, navOptions = navOptions)
}

fun NavGraphBuilder.accountScreen() {
    composable(route = accountScreenRoute) {
        AccountScreen()
    }
}