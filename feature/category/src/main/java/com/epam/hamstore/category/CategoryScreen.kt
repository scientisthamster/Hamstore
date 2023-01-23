package com.epam.hamstore.category

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
internal fun CategoryRoute(
    modifier: Modifier = Modifier
) {
    CategoryScreen(modifier = modifier)
}

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            text = "Category",
            modifier = Modifier
                .align(Alignment.Center),
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
        )
    }
}

@Preview
@Composable
private fun PreviewCategoryScreen() {
    CategoryScreen()
}