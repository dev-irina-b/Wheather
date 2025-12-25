package com.example.wheather

import android.app.Application
import com.example.wheather.di.AppComponent

class WeatherApp : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}