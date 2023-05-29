package ar.edu.unlam.mobile2.NavegationBottom.PantallasPrueba

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ar.edu.unlam.mobile2.NavegationBottom.ItemsMenu
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel
import ar.edu.unlam.mobile2.weatherapi.ui.WeatherViewModel


@Composable
fun NavegationHost(navHostController: NavHostController, weatherViewModel: WeatherViewModel, viewModel: NewsViewModel) {

    NavHost(
        navController = navHostController,
        startDestination = ItemsMenu.Pantalla1.ruta,

        ){
        composable(ItemsMenu.Pantalla1.ruta){
            inicio(weatherViewModel, viewModel)
        }
        composable(ItemsMenu.Pantalla2.ruta){
            filtro()
        }
        composable(ItemsMenu.Pantalla3.ruta){
            favorito()
        }
    }
}