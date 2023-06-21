package ar.edu.unlam.mobile2.mediastackapi.ui


import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel

@Composable
fun SavedNewsList(viewModel: NewsViewModel) {
    val listaNoticias by viewModel.listaNoticias.observeAsState(emptyList())

    val savedNewsSize = getSavedNewsCount(listaNoticias)

    if (savedNewsSize != 0) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(listaNoticias.filter { it.saved }) { item ->
                NewDesign(noticia = item, onItemClick = { nuevoItem ->
                    viewModel.actualizarItem(nuevoItem)
                })
            }
        }
    } else {
        Text(text = "No hay noticias guardadas")
    }
}

fun getSavedNewsCount(lista: List<New>): Int {
    return lista.filter{ it.saved }.size
}


