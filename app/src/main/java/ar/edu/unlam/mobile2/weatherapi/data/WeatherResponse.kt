package ar.edu.unlam.mobile2.weather.data


import ar.edu.unlam.mobile2.weather.data.Current
import ar.edu.unlam.mobile2.weather.data.Location
import ar.edu.unlam.mobile2.weather.data.Request
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("current")
    val current: Current,
    @SerializedName("location")
    val location: Location,
    @SerializedName("request")
    val request: Request
)