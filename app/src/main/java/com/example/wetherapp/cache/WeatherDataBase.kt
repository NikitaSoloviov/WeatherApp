package com.example.wetherapp.cache

interface WeatherDataBase {

    suspend fun fetchAll(): List<WeatherEntity>

    suspend fun saveAll(products: List<WeatherEntity>)

    suspend fun saveOne(product: WeatherEntity)

    suspend fun deleteAll()
}