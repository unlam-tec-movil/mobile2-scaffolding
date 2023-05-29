package ar.edu.unlam.mobile2.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
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
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.mediastackapi.data.Data
import ar.edu.unlam.mobile2.mediastackapi.ui.viewmodel.NewsViewModel

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
        "28/05/2023",
        "Cronica",
        "Titulo de Ejemplo",
        "##"
    )

}

@Composable
fun CardNoticia(
    new: Data,
    modifier: Modifier = Modifier,
    viewmodel: NewsViewModel,
    border: BorderStroke? = null,
    shape: CornerBasedShape = MaterialTheme.shapes.medium
) {
    var favorito by remember { mutableStateOf(false) }

    Card(
        modifier = modifier.padding(10.dp),
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
            //Boton Favoritos
            Row(modifier = Modifier.align(Start)) {
                IconButton(onClick = {
                    Log.d("Click marcador", "Se clickeó el boton de marcadores")
                    viewmodel.onMarkClicked(new)
                    //MOSTRAR ALERT QUE INDIQUE QUE SE AGREGÓ ITEM A LA LISTA
                    //HAY Q HACER Q TMB LA SAQUE DE LA LISTA
                    favorito = !favorito
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




