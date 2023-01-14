package com.epam.hamstore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.epam.hamstore.MainActivityUiState.Loading
import com.epam.hamstore.MainActivityUiState.Success
import com.epam.hamstore.data.repository.UserDataRepository
import com.epam.hamstore.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    userDataRepository: UserDataRepository
) : ViewModel() {
    val uiState: StateFlow<MainActivityUiState> = userDataRepository.userData.map {
        Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = Loading,
        started = SharingStarted.WhileSubscribed(5_000)
    )
}

sealed interface MainActivityUiState {
    object Loading : MainActivityUiState
    data class Success(val userData: UserData) : MainActivityUiState
}