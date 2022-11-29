package com.example.wetherapp.model

import com.google.gson.annotations.SerializedName

data class RvData(
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("main") val main:Main,
)
