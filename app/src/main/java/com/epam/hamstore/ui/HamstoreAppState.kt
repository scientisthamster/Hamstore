package com.epam.hamstore.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberHamstoreAppState(
    navController: NavHostController = rememberNavController(),
): HamstoreAppState {
    return remember(navController) {
        HamstoreAppState(navController)
    }
}

@Stable
class HamstoreAppState(
    val navController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination
}