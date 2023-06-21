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
fun NewsList(viewModel: NewsViewModel, numero:Int){

    val state = viewModel.state

    if (state.news.isNotEmpty()){
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(state.news){
                when(numero){
                    0->
                        CardContainer(it)
                    1->
                        if(it.category.equals("general")){
                            CardContainer(it)
                        }
                    2->
                        if(it.category.equals("business")){
                            CardContainer(it)
                        }
                    3->
                        if(it.category.equals("entertainment")){
                            CardContainer(it)
                        }
                    4->
                        if(it.category.equals("health")){
                            CardContainer(it)
                        }
                    5->
                        if(it.category.equals("science")){
                            CardContainer(it)
                        }
                    6->
                        if(it.category.equals("sports")){
                            CardContainer(it)
                        }
                    7->
                        if(it.category.equals("technology")){
                            CardContainer(it)
                        }
                }
                }
fun NewsList(viewModel: NewsViewModel) {
    //val newList = viewModel.newList
    val listaNoticias by viewModel.listaNoticias.observeAsState(emptyList())

    if (listaNoticias.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(listaNoticias) { item ->
                NewDesign(noticia = item, onItemClick = { nuevoItem ->
                    viewModel.actualizarItem(nuevoItem)
                    viewModel.actualizarItemEnBase(nuevoItem)
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


