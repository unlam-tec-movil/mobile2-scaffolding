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

    //var newList by mutableStateOf(emptyList<New>())

    private val _newList = MutableLiveData<List<New>>(emptyList())

    val newList: LiveData<List<New>>
        get() = _newList

    private var state by mutableStateOf(NewState())

    init {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            delay(2000)
            _newList.value = getNews.getNews()
            state = state.copy(
                isLoading = false
            )
        }
    }


}