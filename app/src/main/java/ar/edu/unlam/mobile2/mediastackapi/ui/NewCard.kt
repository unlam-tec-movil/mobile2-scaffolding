package ar.edu.unlam.mobile2.mediastackapi.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.mediastackapi.New


@Preview(showBackground = true)
@Composable
fun ArticleCard() {
}

@Composable
fun NewDesign(
    noticia: New,
    onItemClick: (New) -> Unit,
    onItemClick2: (New) -> Unit,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    shape: CornerBasedShape = MaterialTheme.shapes.medium
) {
    Card(
        modifier = modifier.padding(10.dp).clickable { onItemClick2(noticia) },
        border = border,
        shape = shape
    ) {
        //Contenedor
        Column(modifier = modifier.padding(10.dp)) {
            //Source
            Text(text = noticia.source!!, style = MaterialTheme.typography.bodyMedium)
            //Titulo
            Text(
                text = noticia.title!!, style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
            )
            //Descripción
            Text(
                text = noticia.description!!,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
            )
            //Boton Favoritos
            Row(modifier = Modifier.align(Alignment.Start)) {
                IconButton(onClick = {
                    Log.d("Click marcador", "Se clickeó el boton de marcadores")
                    onItemClick(noticia.copy(saved = enviarBoolean(noticia)))
                }) {
                    Icon(
                        painter = if (!noticia.saved) {
                            painterResource(id = R.drawable.baseline_bookmark_border_24)
                        } else {
                            painterResource(id = R.drawable.baseline_bookmark_24)
                        }, contentDescription = null
                    )
                }

                Text(
                    text = if (!noticia.saved) {
                        "Agregar a marcadores"
                    } else {
                        "Quitar de marcadores"
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}



private fun enviarBoolean(noticia: New): Boolean {
    return !noticia.saved
}


