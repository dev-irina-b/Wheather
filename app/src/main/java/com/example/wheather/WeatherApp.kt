package com.example.wheather

import android.app.Application
import com.example.wheather.di.AppComponent
import com.example.wheather.di.DaggerAppComponent

class WeatherApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}