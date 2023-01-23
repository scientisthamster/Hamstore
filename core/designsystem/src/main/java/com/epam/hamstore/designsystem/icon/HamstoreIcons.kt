package com.epam.hamstore.designsystem.icon

import androidx.annotation.DrawableRes
import com.epam.hamstore.designsystem.R

object HamstoreIcons {
    val Home = R.drawable.ic_home
    val Category = R.drawable.ic_category
    val Basket = R.drawable.ic_basket
    val Account = R.drawable.ic_account
    val Onboarding_1 = R.drawable.ic_shopping_first
    val Onboarding_2 = R.drawable.ic_shopping_second
    val Onboarding_3 = R.drawable.ic_shopping_third
}

sealed class Icon {
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}