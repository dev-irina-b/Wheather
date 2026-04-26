package com.example.auth.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.example.auth.presentation.screen.AuthScreenRoute
import com.example.core_navigation.NavigationFeature
import com.example.feature_auth_api.AuthRoute
import com.example.feature_home_api.navigation.HomeRoute
import javax.inject.Inject

class AuthNavigationFeature @Inject constructor() : NavigationFeature {
    override fun register(
        builder: NavGraphBuilder,
        onNavigate: (route: String, builder: NavOptionsBuilder.() -> Unit) -> Unit
    ) {
        builder.composable(AuthRoute.route) {
            AuthScreenRoute(
                onNavigateToHome = {
                    onNavigate(HomeRoute.route) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}
