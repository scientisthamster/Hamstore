package com.epam.hamstore.onboardig.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.epam.hamstore.designsystem.icon.HamstoreIcons
import com.epam.hamstore.onboardig.R
import com.epam.hamstore.onboardig.model.OnboardingItem.* // ktlint-disable no-unused-imports

sealed class OnboardingItem(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
) {
    object FirstItem : OnboardingItem(
        image = HamstoreIcons.Onboarding_1,
        title = R.string.sell_title,
        description = R.string.sell_description,
    )

    object SecondItem : OnboardingItem(
        image = HamstoreIcons.Onboarding_2,
        title = R.string.get_reward_title,
        description = R.string.get_reward_description
    )

    object ThirdItem : OnboardingItem(
        image = HamstoreIcons.Onboarding_3,
        title = R.string.buy_title,
        description = R.string.buy_description
    )
}

internal val onboardingItems = listOf(
    FirstItem,
    SecondItem,
    ThirdItem
)