package com.example.home.data.mapper

import com.example.home.data.dto.WeatherDataDto
import com.example.home.domain.models.WeatherData

fun WeatherDataDto.toDomain(): WeatherData =
    WeatherData(
        latitude = latitude,
        longitude= longitude
    )