package ar.edu.unlam.mobile2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ar.edu.unlam.mobile2.mediastackapi.ui.MarcadoresList
import ar.edu.unlam.mobile2.theme.Mobile2_ScaffoldingTheme
import ar.edu.unlam.mobile2.weatherapi.ui.WeatherScreen
import ar.edu.unlam.mobile2.weatherapi.ui.WeatherViewModel
import ar.edu.unlam.mobile2.mediastackapi.ui.NewsList
import ar.edu.unlam.mobile2.mediastackapi.ui.viewmodel.NewsViewModel

import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val weatherViewModel by viewModels<WeatherViewModel>()
    private val mediaViewModel by viewModels<NewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application, "719d2c40-5de1-44d8-980d-aded581ac26d",
            Analytics::class.java, Crashes::class.java
        )
        setContent {
            Mobile2_ScaffoldingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column() {
                        WeatherScreen(weatherViewModel)

                        //Button de prueba, BORRAR MAS TARDE
                        Button(onClick = {
                            val i = Intent(this@MainActivity, ListaMarcadores::class.java)
                            startActivity(i)
                        }) {
                            Text(text = "Marcadores")
                        }
                        //

                        NewsList(mediaViewModel)
                    }
                }
            }
        }
    }
}



