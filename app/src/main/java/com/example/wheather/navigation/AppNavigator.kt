package com.example.wheather.navigation

import androidx.navigation.NavHostController
import com.example.core_navigation.Destination
import com.example.core_navigation.Navigator

class AppNavigator(private val navController: NavHostController) : Navigator {

    override fun navigate(
        destination: Destination,
        popUpTo: Destination?,
        inclusive: Boolean
    ) {
        navController.navigate(destination.route) {
            launchSingleTop = true
            if (popUpTo != null) {
                popUpTo(popUpTo.route) { this.inclusive = inclusive }
            }
        }
    }

    override fun replaceAll(destination: Destination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

    override fun popBack() {
        navController.popBackStack()
    }
}