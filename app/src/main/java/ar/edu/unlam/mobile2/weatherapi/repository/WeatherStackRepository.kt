package ar.edu.unlam.mobile2.weatherapi.repository

import ar.edu.unlam.mobile2.weatherapi.data.WeatherResponse
import javax.inject.Inject

class WeatherStackRepository(private val api: WeatherApiService) {

    suspend fun getWeatherData(location: String): WeatherResponse {
        val apiKey = "585c4078dae4811f59247810dca2bad6"
        return api.getCurrentWeather(apiKey, location)
    }
}
