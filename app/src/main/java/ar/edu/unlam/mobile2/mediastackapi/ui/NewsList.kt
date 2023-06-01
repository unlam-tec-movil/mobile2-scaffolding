package ar.edu.unlam.mobile2.mediastackapi.ui

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewState
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel
import ar.edu.unlam.mobile2.ui.CardContainer

@Composable
fun NewsList(viewModel: NewsViewModel){
    val state = viewModel.state

    val stateLiveData = viewModel.stateLiveData.observeAsState()

    if (stateLiveData.value?.isNotEmpty() == true){
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(stateLiveData.value!!){
                CardContainer(it)
            }
        }
    }else{
        Log.d("Error en lista", "No hay datos para mostrar")
    }
}