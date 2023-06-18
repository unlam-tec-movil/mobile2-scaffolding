package ar.edu.unlam.mobile2.mediastackapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile2.mediastackapi.GetNews
import ar.edu.unlam.mobile2.mediastackapi.New
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNews: GetNews
) : ViewModel() {

    private val _listaNoticias = MutableLiveData<List<New>>()
    val listaNoticias: LiveData<List<New>> = _listaNoticias

    fun actualizarItem(item: New){
        val currentList = _listaNoticias.value.orEmpty().toMutableList()

        val index = currentList.indexOfFirst { it.id == item.id }

        currentList[index] = item
        _listaNoticias.value = currentList
    }

    private var state by mutableStateOf(NewState())

    init {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            _listaNoticias.value = getNews.getNews()
            state = state.copy(
                isLoading = false
            )
        }
    }


}