package ar.edu.unlam.mobile2.mediastackapi.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.BorderStroke

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface

import androidx.compose.material.rememberBottomSheetScaffoldState

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile2.theme.Mobile2_ScaffoldingTheme

@Preview(showSystemUi = true)
@Preview(showBackground = false)
@Composable
fun ArticleCard() {
    val modifier: Modifier = Modifier
    Mobile2_ScaffoldingTheme {
        Box(modifier = modifier.fillMaxWidth()) {
            Card(
                modifier = modifier.padding(5.dp),
                backgroundColor = Color.White,
                shape = CutCornerShape(1.dp)
            ) {
                //Contenedor
                Column(modifier = modifier.padding(5.dp)) {
                    //Source
                    Text(text = "Source", style = MaterialTheme.typography.bodyMedium)
                    //Titulo
                    Text(
                        text = "Titulo", style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                    )
                    //Boton Favoritos
                    Row() {
                        IconButton(onClick = {
                            Log.d("Click marcador", "Se clickeó el boton de marcadores")
                        }) {
                            Icon(
                                painter =
                                painterResource(id = R.drawable.baseline_bookmark_border_24),
                                contentDescription = null
                            )
                        }

                        Text(
                            "Agregar a marcadores",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                }
                //Borde de arriba
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp),
                    color = MaterialTheme.colorScheme.onBackground
                ) {}
            }

        }


    }
}

//noticia.source!!
//noticia.title!!

@Composable
fun NewDesign(
    noticia: New,
    onItemClick: (New) -> Unit,
    onItemClick2: (New) -> Unit,
    modifier: Modifier = Modifier,
){
    Box(modifier = modifier.fillMaxWidth()) {
        Card(
            modifier = modifier.padding(5.dp),
            backgroundColor = Color.White,
            shape = CutCornerShape(1.dp)
        ) {
            //Contenedor
            Column(modifier = modifier.padding(5.dp)) {
                //Source
                Text(text = noticia.source!!, style = MaterialTheme.typography.bodyMedium)
                //Titulo
                Text(
                    text = noticia.title!!, style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                )
                //Descripción
                /*Text(
                    text = noticia.description!!,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium,
                )*/
                //Boton Favoritos
                Row(modifier = Modifier.align(Alignment.End)) {
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
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp),
                color = MaterialTheme.colorScheme.onBackground
            ) {}
        }
    }

}

@Composable
fun NewDesign2(
    noticia: New,
    onItemClick: (New) -> Unit,
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
            Row(modifier = Modifier.align(Alignment.End)) {
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


