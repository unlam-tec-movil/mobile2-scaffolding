package ar.edu.unlam.mobile2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile2.NavegationBottom.ItemsMenu
import ar.edu.unlam.mobile2.NavegationBottom.PantallasPrueba.NavegationHost
import ar.edu.unlam.mobile2.NavegationBottom.PantallasPrueba.Inicio
import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile2.theme.Mobile2_ScaffoldingTheme
import ar.edu.unlam.mobile2.weatherapi.ui.WeatherScreen
import ar.edu.unlam.mobile2.weatherapi.ui.WeatherViewModel
import ar.edu.unlam.mobile2.mediastackapi.ui.NewsList
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel

import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val weatherViewModel by viewModels<WeatherViewModel>()

    //private lateinit var newViewModel:NewsViewModel

    private val newViewModel by viewModels<NewsViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application, "719d2c40-5de1-44d8-980d-aded581ac26d",
            Analytics::class.java, Crashes::class.java
        )
        //newViewModel = ViewModelProvider(this)[NewsViewModel::class.java]

        setContent {
            Mobile2_ScaffoldingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column() {

                        PantallaPrincipal(weatherViewModel,newViewModel)
                    }

                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PantallaPrincipal(weatherViewModel: WeatherViewModel, viewModel:NewsViewModel ) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val navegationItem = listOf(
        ItemsMenu.Pantalla1,
        ItemsMenu.Pantalla2,
        ItemsMenu.Pantalla3
    )

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { NavegacionInferior(navController, navegationItem) })
    {
    NavegationHost(navController,weatherViewModel,viewModel)
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val entrada by navController.currentBackStackEntryAsState()
    return entrada?.destination?.route
}

@Composable
fun NavegacionInferior(navController: NavHostController, menuItem: List<ItemsMenu>) {
    BottomAppBar() {
        BottomNavigation(backgroundColor = Color.Black) {
            val currentRoute = currentRoute(navController = navController)
            menuItem.forEach { item ->
                BottomNavigationItem(
                    selected = currentRoute == item.ruta,
                    onClick = { navController.navigate(item.ruta) },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icono),
                            contentDescription = item.titulo
                        )
                    },
                    label = { Text(item.titulo) }
                )


            }
        }
    }
}
