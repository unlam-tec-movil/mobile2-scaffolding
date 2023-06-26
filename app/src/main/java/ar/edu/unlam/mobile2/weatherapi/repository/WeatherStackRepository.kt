package ar.edu.unlam.mobile2.weatherapi.repository

import ar.edu.unlam.mobile2.weatherapi.data.WeatherResponse

class WeatherStackRepository(private val api: WeatherApiService) {

    suspend fun getWeatherData(location: String): WeatherResponse {
        val apiKey = "e17276e7240c147109db2f997e8030c7"
        return api.getCurrentWeather(apiKey, location)
    }
}
