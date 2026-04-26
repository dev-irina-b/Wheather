package com.example.wheather.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.common.ui.LocalViewModelFactory
import com.example.feature_splash_api.navigation.SplashRoute
import com.example.wheather.di.AppComponent

@Composable
fun AppRoot(
    appComponent: AppComponent
) {
    val navController = rememberNavController()

    val navigationFeatures = remember { appComponent.navigationFeatures() }


    val viewModelFactory = remember { appComponent.viewModelFactory() }

    CompositionLocalProvider(
        LocalViewModelFactory provides viewModelFactory
    ) {
        AppScaffold {
            AppNavHost(
                navController = navController,
                startDestination = SplashRoute.route,
                features = navigationFeatures,
                modifier = Modifier.padding(it)
            )
        }
    }
}
