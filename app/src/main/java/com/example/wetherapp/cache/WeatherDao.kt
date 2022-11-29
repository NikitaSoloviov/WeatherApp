package com.example.wetherapp.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveOne(note: WeatherEntity)

    @Query("SELECT * FROM weather_table")
    suspend fun fetchAll(): List<WeatherEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(notes: List<WeatherEntity>)

    @Query("DELETE FROM weather_table")
    suspend fun deleteAll()
}
