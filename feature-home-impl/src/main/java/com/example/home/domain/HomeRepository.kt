package com.example.home.domain

import com.example.home.domain.models.WeatherData

interface HomeRepository {
    suspend fun getWeatherApi(latitude: Double, longitude: Double): WeatherData
}