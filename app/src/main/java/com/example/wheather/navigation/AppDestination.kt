package com.example.wheather.navigation

import com.example.core_navigation.Destination

sealed class AppDestination(override val route: String) : Destination {
    data object Splash : AppDestination("splash")
    data object Auth  : AppDestination("auth")
    data object Home  : AppDestination("home")
}