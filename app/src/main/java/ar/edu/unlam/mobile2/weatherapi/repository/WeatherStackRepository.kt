package ar.edu.unlam.mobile2.weatherapi.repository

import ar.edu.unlam.mobile2.weatherapi.data.WeatherResponse
import javax.inject.Inject

class WeatherStackRepository(private val api: WeatherApiService) {

    suspend fun getWeatherData(location: String): WeatherResponse {
        val apiKey = "36fcb212c1835907f14f5c1a39beb7eb"
        return api.getCurrentWeather(apiKey, location)
    }
}
