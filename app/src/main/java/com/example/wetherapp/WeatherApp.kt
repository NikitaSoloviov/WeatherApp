package com.example.wetherapp

import android.app.Application
import com.example.wetherapp.cache.WeatherDataBase
import com.example.wetherapp.cache.WeatherDataBaseImpl

class WeatherApp: Application() {

    companion object{
        lateinit var db: WeatherDataBase
    }

    override fun onCreate() {
        super.onCreate()
        db = WeatherDataBaseImpl(this)
    }
}