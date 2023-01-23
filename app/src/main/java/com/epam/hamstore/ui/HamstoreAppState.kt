package com.epam.hamstore.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.epam.hamstore.account.navigation.accountScreenRoute
import com.epam.hamstore.account.navigation.navigateToAccount
import com.epam.hamstore.basket.navigation.basketScreenRoute
import com.epam.hamstore.basket.navigation.navigateToBasket
import com.epam.hamstore.category.navigation.categoryScreenRoute
import com.epam.hamstore.category.navigation.navigateToCategory
import com.epam.hamstore.home.navigation.homeScreenRoute
import com.epam.hamstore.home.navigation.navigateToHomeScreen
import com.epam.hamstore.navigation.TopLevelDestination
import com.epam.hamstore.navigation.TopLevelDestination.*

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

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            homeScreenRoute -> HOME
            categoryScreenRoute -> CATEGORY
            basketScreenRoute -> BASKET
            accountScreenRoute -> ACCOUNT
            else -> null
        }

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (topLevelDestination) {
            HOME -> navController.navigateToHomeScreen(topLevelNavOptions)
            CATEGORY -> navController.navigateToCategory(topLevelNavOptions)
            BASKET -> navController.navigateToBasket(topLevelNavOptions)
            ACCOUNT -> navController.navigateToAccount(topLevelNavOptions)
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}