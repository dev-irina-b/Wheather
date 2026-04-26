package com.example.auth.di

import com.example.auth.presentation.navigation.AuthNavigationFeature
import com.example.core_navigation.NavigationFeature
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
interface AuthNavigationModule {

    @Binds
    @IntoSet
    fun bindAuthNavigation(feature: AuthNavigationFeature): NavigationFeature
}
