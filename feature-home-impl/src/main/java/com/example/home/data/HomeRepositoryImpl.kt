package com.example.home.data

import com.example.home.data.mapper.toDomain
import com.example.home.domain.HomeRepository
import com.example.home.domain.models.WeatherData
import com.example.home.data.remote.HomeApi
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: HomeApi
) : HomeRepository {
    override suspend fun getWeatherApi(latitude: Double, longitude: Double): WeatherData {
        return api.getWeather(latitude, longitude).toDomain()
    }
}