package com.example.wheather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.designsystem.theme.WheatherTheme
import com.example.wheather.WeatherApp
import com.example.wheather.navigation.AppRoot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val appComponent = (application as WeatherApp).appComponent

        setContent {
            WheatherTheme {
                AppRoot(appComponent = appComponent)
            }
        }
    }
}