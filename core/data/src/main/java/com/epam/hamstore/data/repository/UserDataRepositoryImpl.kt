package com.epam.hamstore.data.repository

import com.epam.hamstore.datastore.HamstorePreferencesDataSource
import com.epam.hamstore.model.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val hamstorePreferencesDataSource: HamstorePreferencesDataSource
) : UserDataRepository {

    override val userData: Flow<UserData> = hamstorePreferencesDataSource.userData

    override suspend fun setShouldHideOnboardingScreen(shouldHideOnboardingScreen: Boolean) {
        hamstorePreferencesDataSource.setShouldHideOnboardingScreen(shouldHideOnboardingScreen)
    }
}