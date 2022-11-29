package com.example.wetherapp.model

import com.google.gson.annotations.SerializedName

data class RvList(
    @SerializedName("cod") val cod: Int,
    @SerializedName("message") val message: Int,
    @SerializedName("list") val list: List<RvData>
)
