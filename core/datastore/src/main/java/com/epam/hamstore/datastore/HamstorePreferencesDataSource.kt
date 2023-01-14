package com.epam.hamstore.datastore

import androidx.datastore.core.DataStore
import com.epam.hamstore.core.datastore.UserPreferences
import com.epam.hamstore.model.UserData
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HamstorePreferencesDataSource @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>
) {

    val userData = userPreferences.data
        .map {
            UserData(
                shouldHideOnboardingScreen = it.shouldHideOnboardingScreen
            )
        }

    suspend fun setShouldHideOnboardingScreen(shouldHideOnboardingScreen: Boolean) {
        userPreferences.updateData { preferences ->
            preferences.toBuilder().setShouldHideOnboardingScreen(shouldHideOnboardingScreen)
                .build()
        }
    }
}