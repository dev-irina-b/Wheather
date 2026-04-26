package com.example.home.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class WeatherDataDto(
    val latitude: Double,
    val longitude: Double
) {

}
