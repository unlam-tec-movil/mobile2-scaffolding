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
import androidx.lifecycle.Observer
import androidx.lifecycle.asFlow
import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel
import ar.edu.unlam.mobile2.ui.NewDesign
import com.google.android.filament.Box

@Composable
fun NewsList(viewModel: NewsViewModel) {
    //val newList = viewModel.newList

    val newList by viewModel.newList.observeAsState(emptyList())

    if (newList.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(newList) {
                NewDesign(it.id!!, newList)
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

