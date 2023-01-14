package com.epam.hamstore.data.repository

import com.epam.hamstore.model.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    val userData: Flow<UserData>

    suspend fun setShouldHideOnboardingScreen(shouldHideOnboardingScreen: Boolean)
}