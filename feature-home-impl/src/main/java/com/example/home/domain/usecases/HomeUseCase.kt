package com.example.home.domain.usecases

import com.example.home.domain.models.WeatherData

interface HomeUseCase {
    suspend operator fun invoke(latitude: Double, longitude: Double): WeatherData
}