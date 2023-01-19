package com.epam.hamstore.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.epam.hamstore.home.navigation.homeScreenRoute
import com.epam.hamstore.navigation.HamstoreNavHost
import com.epam.hamstore.onboardig.navigation.onboardingScreenRoute
import kotlinx.coroutines.flow.Flow

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