package ar.edu.unlam.mobile2.mediastackapi.ui.viewmodel

import ar.edu.unlam.mobile2.mediastackapi.data.Data

data class NewState(
    val news: List<Data> = emptyList(),
    val marcadores:  MutableList<Data> = mutableListOf()
)
