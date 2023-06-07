package ar.edu.unlam.mobile2.weatherapi.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.weatherapi.data.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable

fun WeatherScreen(weatherViewModel: WeatherViewModel) {
    var weatherData by remember { mutableStateOf<WeatherResponse?>(null) }

   LaunchedEffect(Unit) {
        val data = withContext(Dispatchers.IO) {
            weatherViewModel.getWeatherData("Buenos Aires")
        }
        weatherData = data
    }
    
   Card(modifier = Modifier
       .padding(1.dp)
       .clickable { }
       .fillMaxWidth(),
   shape = RoundedCornerShape(8.dp)) {
       Column(
           modifier = Modifier.padding(16.dp)
       ) {

        Image(painter = painterResource(
               id = R.drawable.clima),
               contentDescription = "Clima ",
               modifier = Modifier
                   .size(100.dp),
               contentScale = ContentScale.Crop)
               if (weatherData != null) {
                   Text(
                       text = "Temperatura: ${weatherData!!.current.temperature}",
                       color = Color.White,
                       modifier = Modifier.padding(bottom = 8.dp)
                   )

                   Text(
                       text = "Weather Description: ${weatherData!!.current.weatherDescriptions.first()}",
                       color = Color.White,
                       modifier = Modifier.padding(bottom = 8.dp)
                   )
               } else {
                   Text("Loading weather data...")
               }

       }
   }


}