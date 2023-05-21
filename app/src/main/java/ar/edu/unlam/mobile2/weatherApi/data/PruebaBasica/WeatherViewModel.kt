package com.example.apinoticias.PruebaBasica


import androidx.lifecycle.ViewModel
import com.example.apinoticias.data.WeatherResponse
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
