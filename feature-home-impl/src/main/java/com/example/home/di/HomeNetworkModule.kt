package com.example.home.di

import com.example.home.data.remote.HomeApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object HomeNetworkModule {

    @Provides
    fun provideHomeApi(retrofit: Retrofit): HomeApi = retrofit.create(HomeApi::class.java)
}
