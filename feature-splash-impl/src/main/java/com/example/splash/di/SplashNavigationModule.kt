package com.example.splash.di

import com.example.core_navigation.NavigationFeature
import com.example.splash.presentation.navigation.SplashNavigationFeature
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
interface SplashNavigationModule {
    @Binds
    @IntoSet
    fun bindSplashNavigation(feature: SplashNavigationFeature): NavigationFeature
}