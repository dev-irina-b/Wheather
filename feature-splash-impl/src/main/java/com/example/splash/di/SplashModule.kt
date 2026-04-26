package com.example.splash.di

import androidx.lifecycle.ViewModel
import com.example.di.ViewModelKey
import com.example.splash.presentation.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [SplashNavigationModule::class])
interface SplashModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindsSplashViewModel(viewModel: SplashViewModel): ViewModel
}
