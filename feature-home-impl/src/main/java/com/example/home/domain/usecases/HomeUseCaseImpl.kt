package com.example.home.domain.usecases

import com.example.home.domain.HomeRepository
import com.example.home.domain.models.WeatherData
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(private val homeRepository: HomeRepository): HomeUseCase {
    override suspend fun invoke(latitude: Double, longitude: Double): WeatherData  {
        return homeRepository.getWeatherApi(latitude, longitude)
    }
}