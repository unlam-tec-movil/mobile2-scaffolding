package ar.edu.unlam.mobile2.ui

import androidx.compose.foundation.Image
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
fun PantallaColeccion(navigationController: NavHostController) {
    Image(
        painter = painterResource(id = R.drawable.fondo_coleccion),
        contentDescription = "Pantalla Coleccion",
        contentScale = ContentScale.FillHeight,
        modifier = Modifier.fillMaxSize()
    )
    Button(onClick = { navigationController.navigate(Routes.PantallaInicio.route) }) {
        Text(text = "Volver")
    }
}
