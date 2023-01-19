package com.epam.hamstore.onboardig

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.epam.hamstore.data.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository
) : ViewModel() {

    fun shouldHideOnboardingScreen() {
        viewModelScope.launch {
            userDataRepository.setShouldHideOnboardingScreen(true)
        }
    }
}