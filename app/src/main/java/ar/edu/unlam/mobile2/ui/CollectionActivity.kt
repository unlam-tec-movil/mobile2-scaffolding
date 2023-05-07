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
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.domain.hero.DataHero
import ar.edu.unlam.mobile2.ui.ui.theme.Mobile2_ScaffoldingTheme

class CollectionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile2_ScaffoldingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaPruebaCollection()
                    Galeria(heroList = dataHeroTestList())
                }
            }
        }
    }
}


@Preview
@Composable
fun PantallaPruebaCollection() {
    Box{
        Image(
            painter = painterResource(id = R.drawable.fondo_coleccion),
            contentDescription = "Pantalla Coleccion",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )
        Galeria(heroList = dataHeroTestList())
    }
    
}

fun dataHeroTestList(): List<DataHero> {
    val dataHeroTestList = mutableListOf<DataHero>()
    for(i in 0..9999) {
        dataHeroTestList.add(
            DataHero(name = "Test $i", id = "$i", isFavorite = i%3 == 0)
        )
    }
    return dataHeroTestList
}

@Preview
@Composable
fun GaleriaPreview() {
    Galeria(heroList = dataHeroTestList())
}

@Composable
fun Galeria(
            modifier: Modifier = Modifier,
            heroList: List<DataHero>,
            itemSize: Dp = 100.dp
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(itemSize),
        content = {
            items(heroList.size) {i ->
                GaleriaItem(
                    modifier = modifier,
                    dataHero = heroList[i],
                )
            }
        })
}



@Preview
@Composable
fun GaleriaItem(modifier: Modifier = Modifier,
                dataHero: DataHero = DataHero(),
                painterDefaultResourceId: Int = R.drawable.default_imagen_heroe
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .background(brush = SolidColor(Color.Black), alpha = 0.25f)
    ) {
        Column {
            Image(
                painter = painterResource(id = painterDefaultResourceId),
                contentDescription = "Imagen heroe",
                modifier = modifier
                    .fillMaxWidth(1f)
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )
            Text(dataHero.name,
                modifier = modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
        Text(dataHero.id, modifier = modifier.padding(8.dp))
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = modifier
                .fillMaxWidth(1f)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = if(dataHero.isFavorite)
                    R.drawable.icon_favorite else R.drawable.icon_favorite_not
                ),
                contentDescription = if(dataHero.isFavorite) "icono favorito" else "icono no favorito",
                modifier = modifier
            )
        }

    }
}
