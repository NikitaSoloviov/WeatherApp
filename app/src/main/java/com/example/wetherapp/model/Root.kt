package com.example.wetherapp.model

import androidx.room.TypeConverters
import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp")val temp: Double,
    @SerializedName("feels_like") val feelsLike: Double,

)

data class Weather(
    @SerializedName("main")val main: String,
    @SerializedName("description")val description: String
)

data class Clouds(
    @SerializedName("all")val all: Int,
)

data class Wind(
    @SerializedName("speed")val speed: Float,
    @SerializedName("deg")val deg: Int,
)

data class Sys(
    @SerializedName("pod")val pod: String,
)

