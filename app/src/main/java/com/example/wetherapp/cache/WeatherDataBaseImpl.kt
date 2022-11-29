package com.example.wetherapp.cache

import android.content.Context
import androidx.room.Room

class WeatherDataBaseImpl(context: Context) : WeatherDataBase {

    private val db = Room.databaseBuilder(
        context,
        WeatherAppDb::class.java,
        WeatherAppDb.NAME
    ).build()

    private val dao = db.weatherDao()

    override suspend fun fetchAll(): List<WeatherEntity>  = dao.fetchAll()
    override suspend fun saveAll(products: List<WeatherEntity>) = dao.saveAll(products)
    override suspend fun saveOne(product: WeatherEntity) = dao.saveOne(product)
    override suspend fun deleteAll() = dao.deleteAll()
}