package com.example.wheather.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import com.example.core_navigation.NavigationFeature

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String,
    features: Set<NavigationFeature>,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        val onNavigate: (String, NavOptionsBuilder.() -> Unit) -> Unit =
            { route, options ->
                navController.navigate(route) {
                    launchSingleTop = true
                    options()
                }
            }
        features.forEach { feature ->
            feature.register(this, onNavigate)
        }
    }
}
