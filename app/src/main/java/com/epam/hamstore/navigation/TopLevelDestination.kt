package com.epam.hamstore.navigation

import com.epam.hamstore.designsystem.icon.HamstoreIcons
import com.epam.hamstore.designsystem.icon.Icon
import com.epam.hamstore.designsystem.icon.Icon.DrawableResourceIcon

enum class TopLevelDestination(
    val icon: Icon,
) {
    HOME(
        icon = DrawableResourceIcon(HamstoreIcons.Home),
    ),
    CATEGORY(
        icon = DrawableResourceIcon(HamstoreIcons.Category),
    ),
    BASKET(
        icon = DrawableResourceIcon(HamstoreIcons.Basket),
    ),
    ACCOUNT(
        icon = DrawableResourceIcon(HamstoreIcons.Account),
    )
}