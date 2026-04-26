package com.example.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.example.core_navigation.NavigationFeature
import com.example.feature_home_api.navigation.HomeRoute
import com.example.home.presentation.screens.HomeScreenRoute
import javax.inject.Inject

class HomeNavigationFeature @Inject constructor() : NavigationFeature {
    override fun register(
        builder: NavGraphBuilder,
        onNavigate: (route: String, builder: NavOptionsBuilder.() -> Unit) -> Unit
    ) {
        builder.composable(HomeRoute.route) {
            HomeScreenRoute()
        }
    }
}
