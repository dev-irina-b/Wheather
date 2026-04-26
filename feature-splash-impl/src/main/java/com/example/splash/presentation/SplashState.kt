package com.example.splash.presentation

data class SplashState(
    val destination: SplashDestination? = null
)

sealed class SplashDestination {
    object Home : SplashDestination()
    object Auth : SplashDestination()
}