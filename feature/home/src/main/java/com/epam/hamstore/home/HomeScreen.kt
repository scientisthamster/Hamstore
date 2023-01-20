package com.epam.hamstore.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
internal fun HomeRoute() {
    HomeScreen()
}

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            "Home",
            modifier = Modifier
                .align(Alignment.Center),
            fontSize = 40.sp
        )
    }
}