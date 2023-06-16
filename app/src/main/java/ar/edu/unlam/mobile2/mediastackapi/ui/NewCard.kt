package ar.edu.unlam.mobile2.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel


@Preview(showBackground = true)
@Composable
fun ArticleCard() {
}

@Composable
fun NewDesign(
    new: Int,
    newList: List<New>,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    shape: CornerBasedShape = MaterialTheme.shapes.medium
) {
    Card(
        modifier = modifier.padding(10.dp),
        border = border,
        shape = shape
    ) {
        //Contenedor
        Column(modifier = modifier.padding(10.dp)) {
            //Source
            Text(text = newList[new].source!!, style = MaterialTheme.typography.bodyMedium)
            //Titulo
            Text(
                text = newList[new].title!!, style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
            )
            //Descripción
            Text(
                text = newList[new].description!!,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
            )
            //Boton Favoritos
            Row(modifier = Modifier.align(Alignment.Start)) {
                IconButton(onClick = {
                    Log.d("Click marcador", "Se clickeó el boton de marcadores")

                    //Actualiza el valor Saved mediante Observer
                    newList[new].saved = !newList[new].saved

                }) {
                    Icon(
                        painter = if (!newList[new].saved) {
                            painterResource(id = R.drawable.baseline_bookmark_border_24)
                        } else {
                            painterResource(id = R.drawable.baseline_bookmark_24)
                        }, contentDescription = null
                    )
                }

                Text(
                    text = if (!newList[new].saved) {
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

