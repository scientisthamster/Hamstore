package com.epam.hamstore.onboardig.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.epam.hamstore.onboardig.OnboardingRoute

const val onboardingScreenRoute = "onboarding_screen_route"

fun NavGraphBuilder.onboardingScreen(
    navigateToHome: () -> Unit
) {
    composable(route = onboardingScreenRoute) {
        OnboardingRoute(navigateToHomeScreen = navigateToHome)
    }
}