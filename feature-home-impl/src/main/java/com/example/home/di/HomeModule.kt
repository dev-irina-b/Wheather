package com.example.home.di

import androidx.lifecycle.ViewModel
import com.example.di.ViewModelKey
import com.example.home.data.HomeRepositoryImpl
import com.example.home.domain.HomeRepository
import com.example.home.domain.usecases.HomeUseCase
import com.example.home.domain.usecases.HomeUseCaseImpl
import com.example.home.presentation.navigation.HomeNavigationFeature
import com.example.home.presentation.viewmodels.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [HomeNavigationModule::class, HomeNetworkModule::class])
abstract class HomeModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    abstract fun bindHomeUseCase(impl: HomeUseCaseImpl): HomeUseCase

    @Binds
    abstract fun bindHomeRepository(impl: HomeRepositoryImpl): HomeRepository
}
