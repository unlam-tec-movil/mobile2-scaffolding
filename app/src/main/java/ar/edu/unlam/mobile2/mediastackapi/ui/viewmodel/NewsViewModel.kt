package ar.edu.unlam.mobile2.mediastackapi.ui.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile2.MainActivity
import ar.edu.unlam.mobile2.mediastackapi.repository.NewsRepository
import ar.edu.unlam.mobile2.mediastackapi.data.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    var state by mutableStateOf(NewState())
        private set

    init {
        viewModelScope.launch {
            repository.getNews().onSuccess {
                state = state.copy(
                    news = it
                )
            }.onFailure {
                Log.e("Error en lista", "No hay datos para mostrar")
            }
        }
    }

    fun onNewClicked(new: Data){
        Log.d("Noticia Clickeada", new.title)
    }

    fun onMarkClicked(new: Data){
        Log.d("Se clickeo marcador", new.title)

        val index = state.news.indexOf(new)
        val noticia = state.news[index]
        val listaMarcadores = state.marcadores.toMutableList()

        listaMarcadores.add(noticia)

        state = state.copy(
            marcadores = listaMarcadores
        )
    }
}
