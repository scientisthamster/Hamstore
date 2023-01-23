package com.epam.hamstore.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.epam.hamstore.designsystem.component.HamstoreNavigationBar
import com.epam.hamstore.designsystem.component.HamstoreNavigationBarItem
import com.epam.hamstore.designsystem.icon.Icon.DrawableResourceIcon
import com.epam.hamstore.designsystem.theme.Black70
import com.epam.hamstore.designsystem.theme.Grey30
import com.epam.hamstore.designsystem.theme.Orange100
import com.epam.hamstore.home.navigation.homeScreenRoute
import com.epam.hamstore.navigation.HamstoreNavHost
import com.epam.hamstore.navigation.TopLevelDestination
import com.epam.hamstore.onboardig.navigation.onboardingScreenRoute

@Composable
fun HamstoreApp(
    shouldHideOnboardingScreen: Boolean,
    appState: HamstoreAppState = rememberHamstoreAppState()
) {
    Scaffold(modifier = Modifier,
        bottomBar = {
            appState.currentDestination?.route?.let {
                if (it != onboardingScreenRoute) {
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Grey30),
                    )
                    HamstoreBottomBar(
                        destinations = appState.topLevelDestinations,
                        onNavigateToDestination = appState::navigateToTopLevelDestination,
                        currentDestination = appState.currentDestination
                    )
                }
            }
        }
    ) { padding ->
        HamstoreNavHost(
            navController = appState.navController,
            startDestination = if (shouldHideOnboardingScreen) homeScreenRoute else onboardingScreenRoute,
            modifier = Modifier.padding(padding)
        )
    }
}

@Composable
private fun HamstoreBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    HamstoreNavigationBar(
        modifier = modifier
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            val contentColor = if (selected) Orange100 else Black70
            HamstoreNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    when (destination.icon) {
                        is DrawableResourceIcon -> Icon(
                            painter = painterResource(id = destination.icon.id),
                            contentDescription = null,
                            tint = contentColor
                        )
                    }
                }
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, ignoreCase = true) ?: false
    } ?: false