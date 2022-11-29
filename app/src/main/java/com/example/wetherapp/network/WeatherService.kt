package com.example.wetherapp.network

import com.example.wetherapp.model.RvList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast")
    fun getWeather(
        @Query("q") city: String,
        @Query("appid") appid: String
    ): Call<RvList>
}