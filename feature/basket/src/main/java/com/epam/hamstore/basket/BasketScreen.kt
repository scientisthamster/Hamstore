package com.epam.hamstore.basket

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
internal fun BasketRoute(
    modifier: Modifier = Modifier
) {
    BasketScreen(modifier = modifier)
}

@Composable
internal fun BasketScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Basket",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        )
    }
}

@Preview
@Composable
private fun PreviewBasketScreen() {
    BasketScreen()
}