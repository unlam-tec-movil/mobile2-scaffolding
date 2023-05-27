package ar.edu.unlam.mobile2.mediastackapi.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel
import ar.edu.unlam.mobile2.ui.CardContainer
import ar.edu.unlam.mobile2.ui.CardNoticia

@Composable
fun NewsList(viewModel: NewsViewModel){
    val state = viewModel.state

    if (state.news.isNotEmpty()){
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(state.news){
                CardNoticia(it)
            }
        }
    }else{
        Log.d("Error en lista", "No hay datos para mostrar")
    }
}