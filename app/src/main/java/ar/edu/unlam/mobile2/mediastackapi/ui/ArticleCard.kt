package ar.edu.unlam.mobile2.ui

import android.util.Log
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.End
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.mediastackapi.data.Data

@Preview(showBackground = true)
@Composable
fun ArticleCard() {
    val datoEjemplo = Data(
        "Autor",
        "General",
        "Argentina",
        "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",
        "##",
        "Español",
        "26/5/2023",
        "Cronica",
        "Titulo de Ejemplo",
        "##"
    )

    CardNoticia(datoEjemplo)
}

@Composable
fun CardContainer(new: Data) {
    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .padding(vertical = 10.dp)
            .height(height = maxOf(100.dp))
    ) {
        Text(text = new.category)
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = new.title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = new.description)
        Divider()
    }
}

@Composable
fun CardNoticia(
    new: Data,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    shape: CornerBasedShape = MaterialTheme.shapes.medium
) {
    var favorito by remember { mutableStateOf(false) }

    Card(
        modifier = modifier,
        border = border,
        shape = shape
    ) {
        //Contenedor
        Column(modifier = modifier.padding(10.dp)) {
            //Source
            Text(text = new.source, style = MaterialTheme.typography.bodyMedium)
            //Titulo
            Text(
                text = new.title, style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
            )
            //Descripción
            Text(
                text = new.description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
            )
            //Fecha de publicacion
            Text(text = new.publishedAt, style = MaterialTheme.typography.bodySmall)
            //Boton Favoritos
            Row(modifier = Modifier.align(Start)) {
                IconButton(onClick = {
                    AnadirNoticiaAMarcadores(new)
                    favorito != favorito
                }) {
                    Icon(
                        painter = if (!favorito) {
                            painterResource(id = R.drawable.baseline_bookmark_border_24)
                        } else {
                            painterResource(id = R.drawable.baseline_bookmark_24)
                        }, contentDescription = null
                    )
                }

                Text(
                    text = if (!favorito) {
                        "Agregar a marcadores"
                    } else {
                        "Quitar de marcadores"
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(CenterVertically)
                )
            }
        }
    }
}

private fun AnadirNoticiaAMarcadores(noticia: Data) {

}


