package com.example.wheather.navigation

import com.example.core_navigation.NavigationFeature
import com.example.core_navigation.Navigator
import com.example.splash.presentation.navigation.SplashNavigationFeature

class AppNavigationGraph {

    fun provideSplashFeature(navigator: Navigator): NavigationFeature =
        SplashNavigationFeature(
            route = AppDestination.Splash.route,
            onAuthorized = { navigator.replaceAll(AppDestination.Home) },
            onUnauthorized = { navigator.replaceAll(AppDestination.Auth) }
        )
}