package com.example.splash.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core_navigation.NavigationFeature
import com.example.core_navigation.Navigator
import com.example.splash.presentation.screen.SplashRoute

class SplashNavigationFeature(
    private val route: String,
    private val onAuthorized: () -> Unit,
    private val onUnauthorized: () -> Unit
) : NavigationFeature {
    override fun register(builder: NavGraphBuilder, navigator: Navigator) {
        builder.composable(route) {
            SplashRoute(
                onAuthorized = onAuthorized,
                onUnauthorized = onUnauthorized
            )
        }
    }
}
