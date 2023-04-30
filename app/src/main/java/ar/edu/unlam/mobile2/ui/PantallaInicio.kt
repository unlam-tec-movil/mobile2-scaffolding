package ar.edu.unlam.mobile2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.data.Routes

@Composable
fun PantallaDeInicio(navigationController: NavHostController) {
    Image(
        painter = painterResource(id = R.drawable.pantalla_principal),
        contentDescription = "Pantalla principal",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxSize()
    )
    Column() {
        Button(onClick = { navigationController.navigate(Routes.PantallaPelea.route) }) {
            Text(text = "Start")
        }
        Button(onClick = { navigationController.navigate(Routes.PantallaColeccionable.route) }) {
            Text(text = "Coleccionable")
        }
        
    }


}
