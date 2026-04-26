package com.example.wheather.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.core_navigation.NavigationFeature
import com.example.core_navigation.Navigator

@Composable
fun AppNavHost(
    navController: NavHostController,
    navigator: Navigator,
    startDestination: String,
    features: Set<NavigationFeature>,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        features.forEach { feature ->
            feature.register(this, navigator)
        }
    }
}
