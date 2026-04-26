package com.example.home.presentation.states

import com.example.home.domain.models.WeatherData

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Success(val weatherData: WeatherData) : HomeUiState
    data class Error(val message: String) : HomeUiState
}
