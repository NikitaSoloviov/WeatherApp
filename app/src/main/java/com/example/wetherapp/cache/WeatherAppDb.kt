package com.example.wetherapp.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(

    version = 1,
    entities = [
        WeatherEntity::class
    ]
)
@TypeConverters(TypeConverter::class)


abstract class WeatherAppDb: RoomDatabase() {

    companion object{
        const val NAME = "weather_database.db"
    }

    abstract fun weatherDao(): WeatherDao
}