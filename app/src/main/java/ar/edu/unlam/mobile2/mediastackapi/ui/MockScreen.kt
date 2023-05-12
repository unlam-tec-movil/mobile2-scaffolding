package ar.edu.unlam.mobile2.mediastackapi.ui

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
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.MockViewModel

@Composable
fun MockScreen(viewModel: MockViewModel){
    val state = viewModel.state

    if (state.news.isNotEmpty()){
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(state.news){
                Column(Modifier.padding(15.dp)) {
                    Text(text = it.title)
                    Text(text = it.category)
                    Divider()
                }
            }
        }
    }else{
        Text(text = "No hay nada compañero")
    }
}