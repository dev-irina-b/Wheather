package com.example.core_navigation

import androidx.navigation.NavGraphBuilder

interface NavigationFeature {
    fun register(builder: NavGraphBuilder, navigator: Navigator)
}