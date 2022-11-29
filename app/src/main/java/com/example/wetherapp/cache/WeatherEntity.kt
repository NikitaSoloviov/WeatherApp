package com.example.wetherapp.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class WeatherEntity(

    val temp: Double,
    val main: String,
    val feelsLike: Double,
    val description: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)
