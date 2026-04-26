package com.example.auth.di

import androidx.lifecycle.ViewModel
import com.example.auth.data.AuthRemoteDataSource
import com.example.auth.data.AuthRemoteDataSourceImpl
import com.example.auth.data.AuthRepositoryImpl
import com.example.auth.domain.AuthRepository
import com.example.auth.domain.AuthUseCase
import com.example.auth.domain.AuthUseCaseImpl
import com.example.auth.presentation.AuthViewModel
import com.example.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [AuthNavigationModule::class])
interface AuthModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel

    @Binds
    fun bindAuthRemoteDataSource(impl: AuthRemoteDataSourceImpl): AuthRemoteDataSource

    @Binds
    fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @Binds
    fun bindAuthUseCase(impl: AuthUseCaseImpl): AuthUseCase
}
