package ar.edu.unlam.mobile2.mediastackapi.ui

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ar.edu.unlam.mobile2.mediastackapi.ui.viewmodel.NewsViewModel
import ar.edu.unlam.mobile2.ui.CardNoticia

@Composable
fun MarcadoresList(viewModel: NewsViewModel){
    val state = viewModel.state.marcadores

    if (state.isNotEmpty()){
        LazyColumn(modifier = Modifier.fillMaxWidth()
        ){
            items(state){
                CardNoticia(it, modifier = Modifier.clickable { viewModel.onNewClicked(it) }, viewModel)
            }
        }
    }else{
        Text(text = "No hay noticias guardadas", modifier = Modifier.fillMaxWidth())
    }
}