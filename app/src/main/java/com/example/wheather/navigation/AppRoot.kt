package com.example.wheather.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.common.ui.LocalViewModelFactory
import com.example.wheather.di.AppComponent

@Composable
fun AppRoot(
    appComponent: AppComponent
) {
    val navController = rememberNavController()
    val navigator = remember(navController) { AppNavigator(navController) }

    val navigationFeatures = remember { appComponent.navigationFeatures() }
    val appNavigationGraph = remember { AppNavigationGraph() }
    val splashFeature = remember(navigator) {
        appNavigationGraph.provideSplashFeature(navigator)
    }
    val features = remember(navigationFeatures, splashFeature) {
        navigationFeatures + splashFeature
    }

    val viewModelFactory = remember { appComponent.viewModelFactory() }

    CompositionLocalProvider(LocalViewModelFactory provides viewModelFactory) {
        AppScaffold {
            AppNavHost(
                navController = navController,
                navigator = navigator,
                startDestination = AppDestination.Splash.route,
                features = features,
                modifier = Modifier.padding(it)
            )
        }
    }
}
