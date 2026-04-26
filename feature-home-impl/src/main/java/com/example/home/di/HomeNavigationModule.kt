package com.example.home.di

import com.example.core_navigation.NavigationFeature
import com.example.home.presentation.navigation.HomeNavigationFeature
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
interface HomeNavigationModule {
    @Binds
    @IntoSet
    fun bindHomeNavigation(feature: HomeNavigationFeature): NavigationFeature
}
