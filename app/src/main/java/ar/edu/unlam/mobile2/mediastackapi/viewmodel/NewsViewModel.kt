package ar.edu.unlam.mobile2.mediastackapi.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile2.mediastackapi.NewsRepository
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

    val stateLiveData: MutableLiveData<List<Data>> by lazy {
        MutableLiveData<List<Data>>()
    }

    init {
        viewModelScope.launch {
            repository.getNews().onSuccess {
                stateLiveData.value = it
                Log.i("SUCCESS API", "Se recibieron datos de la api")
            }.onFailure {
                Log.e("FAILURE API", "NO se recibieron datos de la api")
            }
        }
    }
}