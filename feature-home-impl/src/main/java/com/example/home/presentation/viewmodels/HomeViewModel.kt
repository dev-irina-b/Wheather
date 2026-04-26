package com.example.home.presentation.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.common.ui.base.BaseViewModel
import com.example.home.domain.usecases.HomeUseCase
import com.example.home.presentation.states.HomeUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : BaseViewModel<HomeUiState>(HomeUiState.Loading) {

    init {
        getWeather()
    }

    fun getWeather() {
        viewModelScope.launch {
            updateState { HomeUiState.Loading }
            runCatching {
                homeUseCase(latitude = 55.7558, longitude = 37.6173)
            }.onSuccess { weatherData ->
                updateState { HomeUiState.Success(weatherData) }
            }.onFailure {
                updateState { HomeUiState.Error("Unable to load weather") }
            }
        }
    }
}
