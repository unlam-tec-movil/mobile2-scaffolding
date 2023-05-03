package ar.edu.unlam.mobile2.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.ui.ui.theme.Mobile2_ScaffoldingTheme

class ColeccionablesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile2_ScaffoldingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Galeria()
                }
            }
        }
    }
}



@Preview
@Composable
fun Galeria(tamanioItem: Dp = 100.dp, cant: Int = 100) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(tamanioItem),
        content = {
            items(cant) {i ->
                GaleriaItem(
                    idHeroe = i,
                    nombreHeroe = "test $i"
                )
            }
        })
}

@Preview
@Composable
fun GaleriaItem(idHeroe: Int = 9999,
                nombreHeroe: String = "test",
                esFavorito: Boolean = false,
                painterResourceId: Int = R.drawable.default_imagen_heroe) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color.Red)
            .wrapContentHeight()
    ) {

        Column {
            Image(
                painter = painterResource(id = painterResourceId),
                contentDescription = "Imagen heroe",
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )
            Text(nombreHeroe,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
        Text(idHeroe.toString(), modifier = Modifier.padding(8.dp))
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_favorite_not),
                contentDescription = "icono no favorito",
                modifier = Modifier
            )
        }

    }
}

