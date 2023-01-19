package com.epam.hamstore.ui

import androidx.compose.runtime.Composable
import com.epam.hamstore.home.navigation.homeScreenRoute
import com.epam.hamstore.navigation.HamstoreNavHost
import com.epam.hamstore.onboardig.navigation.onboardingScreenRoute

@Composable
fun HamstoreApp(
    shouldHideOnboardingScreen: Boolean,
    appState: HamstoreAppState = rememberHamstoreAppState()
) {
    HamstoreNavHost(
        navController = appState.navController,
        startDestination = if (shouldHideOnboardingScreen) homeScreenRoute else onboardingScreenRoute
    )
}