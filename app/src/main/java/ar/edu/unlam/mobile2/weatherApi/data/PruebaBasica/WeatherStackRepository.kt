package com.example.apinoticias.PruebaBasica

import com.example.apinoticias.data.WeatherResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class WeatherStackRepository @Inject constructor(val api : WeatherApiService){

    suspend fun getWeatherData(location: String): WeatherResponse {
        val apiKey = "66ac0662f66cbb355fa608bbc1cbea5a"
        return api.getCurrentWeather(apiKey, location)
    }
}
