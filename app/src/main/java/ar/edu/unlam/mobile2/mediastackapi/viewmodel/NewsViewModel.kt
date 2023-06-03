package ar.edu.unlam.mobile2.mediastackapi.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile2.mediastackapi.data.NewRepository
import ar.edu.unlam.mobile2.mediastackapi.data.api.response.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewRepository
) : ViewModel() {

    val stateLiveData: MutableLiveData<List<New>> by lazy {
        MutableLiveData<List<New>>()
    }

    init {
        viewModelScope.launch {
            repository.getNewsFromApi().onSuccess {
                stateLiveData.value = it
                Log.i("SUCCESS API", "Se recibieron datos de la api")
            }.onFailure {
                Log.e("FAILURE API", "NO se recibieron datos de la api")
            }
        }
    }
}