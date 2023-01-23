package com.epam.hamstore.designsystem.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.epam.hamstore.designsystem.R

val Typography = Typography(
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
    )
)

// Style for text
private val UrbanistBold = FontFamily(Font(R.font.urbanist_bold))
private val UrbanistSemiBold = FontFamily(Font(R.font.urbanist_semibold))

val titleMedium = TextStyle(
    color = DarkBlue90,
    fontWeight = FontWeight.Bold,
    fontFamily = UrbanistBold,
    fontSize = 48.sp,
)

val subtitleSmall = TextStyle(
    color = Grey50,
    fontWeight = FontWeight.Normal,
    fontFamily = UrbanistSemiBold,
    fontSize = 16.sp,
    lineHeight = 32.sp,
)

val subtitleSmallBlack = subtitleSmall.copy(color = Black100)

val buttonTextSmall = TextStyle(
    color = White100,
    fontWeight = FontWeight.Normal,
    fontFamily = UrbanistSemiBold,
    fontSize = 16.sp,
)