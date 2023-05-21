package ar.edu.unlam.mobile2.weather.repository

import ar.edu.unlam.mobile2.weather.data.WeatherResponse
import javax.inject.Inject

class WeatherStackRepository @Inject constructor(val api : WeatherApiService){

    suspend fun getWeatherData(location: String): WeatherResponse {
        val apiKey = "66ac0662f66cbb355fa608bbc1cbea5a"
        return api.getCurrentWeather(apiKey, location)
    }
}
