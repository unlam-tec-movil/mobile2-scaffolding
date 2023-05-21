package ar.edu.unlam.mobile2.weather.ui


import androidx.lifecycle.ViewModel
import ar.edu.unlam.mobile2.weather.repository.WeatherStackRepository
import ar.edu.unlam.mobile2.weather.data.WeatherResponse
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherStackRepository,
) : ViewModel() {

    suspend fun getWeatherData(location: String): WeatherResponse {
        return repository.getWeatherData(location)
    }
}
