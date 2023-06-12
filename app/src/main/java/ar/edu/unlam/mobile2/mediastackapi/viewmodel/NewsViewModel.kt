package ar.edu.unlam.mobile2.mediastackapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile2.mediastackapi.GetNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNews: GetNews) : ViewModel() {

    var state by mutableStateOf(NewState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(
               isLoading = true
            )
            delay(2000)
            val noticias = getNews.getNews()
            state = state.copy(
                news = getNews.getNews(),
                isLoading = false
            )
        }
    }
}