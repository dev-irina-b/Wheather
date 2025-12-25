package com.example.wheather.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.auth.presentation.screen.AuthScreen
import com.example.splash.screen.SplashScreen
import com.example.wheather.ui.screen.HomeScreen
import kotlinx.coroutines.delay

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    val isAuthorized = false

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH,
        modifier = modifier
    ) {
        composable(Routes.SPLASH) {
            SplashScreen()

            LaunchedEffect(Unit) {
                delay(1500)

                if (isAuthorized) {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                    }
                } else {
                    navController.navigate(Routes.AUTH) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                    }
                }
            }
        }

        composable(Routes.AUTH) {
            AuthScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.AUTH) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.HOME) {
            HomeScreen()
        }
    }
}