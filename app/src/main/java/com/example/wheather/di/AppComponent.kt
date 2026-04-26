package com.example.wheather.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.auth.di.AuthModule
import com.example.core.session.di.SessionModule
import com.example.core_navigation.NavigationFeature
import com.example.di.DispatcherModule
import com.example.di.ViewModelFactoryModule
import com.example.home.di.HomeModule
import com.example.network.di.NetworkModule
import com.example.splash.di.SplashModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        SessionModule::class,
        NetworkModule::class,
        SplashModule::class,
        AuthModule::class,
        ViewModelFactoryModule::class,
        HomeModule::class,
        DispatcherModule::class
    ]
)
interface AppComponent {

    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun navigationFeatures(): Set<NavigationFeature>
}
