package com.example.core_navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder

interface NavigationFeature {
    fun register(
        builder: NavGraphBuilder,
        onNavigate: (route: String, builder: NavOptionsBuilder.() -> Unit) -> Unit
    )
}