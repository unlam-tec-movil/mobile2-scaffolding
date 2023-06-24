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
import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel

@Composable
fun NewsList(viewModel: NewsViewModel, numero: Int) {
    val listaNoticias by viewModel.listaNoticias.observeAsState(emptyList())

    if (listaNoticias.isNotEmpty()) {

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(listaNoticias) { item ->
                when (numero) {
                    0 ->
                        NewDesign(noticia = item, onItemClick = { nuevoItem ->
                            viewModel.actualizarItem(nuevoItem)
                            viewModel.actualizarItemEnBase(nuevoItem)
                        })

                    1 ->
                        if (item.category.equals("general")) {
                            NewDesign(noticia = item, onItemClick = { nuevoItem ->
                                viewModel.actualizarItem(nuevoItem)
                                viewModel.actualizarItemEnBase(nuevoItem)
                            })
                        }

                    2 ->
                        if (item.category.equals("business")) {
                            NewDesign(noticia = item, onItemClick = { nuevoItem ->
                                viewModel.actualizarItem(nuevoItem)
                                viewModel.actualizarItemEnBase(nuevoItem)
                            })
                        }

                    3 ->
                        if (item.category.equals("entertainment")) {
                            NewDesign(noticia = item, onItemClick = { nuevoItem ->
                                viewModel.actualizarItem(nuevoItem)
                                viewModel.actualizarItemEnBase(nuevoItem)
                            })
                        }

                    4 ->
                        if (item.category.equals("health")) {
                            NewDesign(noticia = item, onItemClick = { nuevoItem ->
                                viewModel.actualizarItem(nuevoItem)
                                viewModel.actualizarItemEnBase(nuevoItem)
                            })
                        }

                    5 ->
                        if (item.category.equals("science")) {
                            NewDesign(noticia = item, onItemClick = { nuevoItem ->
                                viewModel.actualizarItem(nuevoItem)
                                viewModel.actualizarItemEnBase(nuevoItem)
                            })
                        }

                    6 ->
                        if (item.category.equals("sports")) {
                            NewDesign(noticia = item, onItemClick = { nuevoItem ->
                                viewModel.actualizarItem(nuevoItem)
                                viewModel.actualizarItemEnBase(nuevoItem)
                            })
                        }

                    7 ->
                        if (item.category.equals("technology")) {
                            NewDesign(noticia = item, onItemClick = { nuevoItem ->
                                viewModel.actualizarItem(nuevoItem)
                                viewModel.actualizarItemEnBase(nuevoItem)
                            })
                        }
                }

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


