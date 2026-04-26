package com.example.splash.presentation

sealed interface SplashEffect {
    object NavigateToHome : SplashEffect
    object NavigateToAuth : SplashEffect
}