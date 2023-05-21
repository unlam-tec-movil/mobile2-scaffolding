package ar.edu.unlam.mobile2.mediastackapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile2.mediastackapi.MediastackApi
import ar.edu.unlam.mobile2.mediastackapi.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MockViewModel @Inject constructor(
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
                println("funca")
            }.onFailure {
                println("uh")
            }
        }
    }
}