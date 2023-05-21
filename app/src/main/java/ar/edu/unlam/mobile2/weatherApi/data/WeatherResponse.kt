package com.example.apinoticias.data


import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("current")
    val current: Current,
    @SerializedName("location")
    val location: Location,
    @SerializedName("request")
    val request: Request
)