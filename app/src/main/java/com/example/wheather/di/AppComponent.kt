package com.example.wheather.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class,
        SessionModule::class
    ]
)
interface AppComponent {

    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}