package com.example.splash.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.example.core_navigation.NavigationFeature
import com.example.feature_auth_api.AuthRoute
import com.example.feature_home_api.navigation.HomeRoute
import com.example.feature_splash_api.navigation.SplashRoute
import com.example.splash.presentation.screen.SplashScreenRoute
import javax.inject.Inject

class SplashNavigationFeature @Inject constructor() : NavigationFeature {
    override fun register(
        builder: NavGraphBuilder,
        onNavigate: (route: String, builder: NavOptionsBuilder.() -> Unit) -> Unit
    ) {
        builder.composable(SplashRoute.route) {
            SplashScreenRoute(
                onNavigateToHome = {
                    onNavigate(HomeRoute.route) {
                        popUpTo(0)
                    }
                },
                onNavigateToAuth = {
                    onNavigate(AuthRoute.route) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}
