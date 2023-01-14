package com.epam.hamstore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.epam.hamstore.home.navigation.homeScreen
import com.epam.hamstore.home.navigation.navigateToHomeScreen
import com.epam.hamstore.onboardig.navigation.onboardingScreen
import com.epam.hamstore.onboardig.navigation.onboardingScreenRoute

@Composable
internal fun HamstoreNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = onboardingScreenRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        onboardingScreen(
            navigateToHome = {
                navController.navigateToHomeScreen()
            }
        )
        homeScreen()
    }
}