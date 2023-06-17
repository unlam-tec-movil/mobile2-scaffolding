package ar.edu.unlam.mobile2.mediastackapi.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel

@Composable
fun NewsList(viewModel: NewsViewModel) {
    //val newList = viewModel.newList
    val listaNoticias by viewModel.listaNoticias.observeAsState(emptyList())

    if (listaNoticias.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(listaNoticias) { item ->
                NewDesign(noticia = item, onItemClick = { nuevoItem ->
                    viewModel.actualizarItem(nuevoItem)
                })
            }
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()

            Log.d("Error en lista", "No hay datos para mostrar")
        }
    }


}


