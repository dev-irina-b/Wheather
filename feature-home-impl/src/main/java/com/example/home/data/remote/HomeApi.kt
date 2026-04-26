package com.example.home.data.remote

import com.example.home.data.dto.WeatherDataDto
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {

    @GET("v1/forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
    ): WeatherDataDto
}