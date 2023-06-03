package ar.edu.unlam.mobile2.mediastackapi.viewmodel

import ar.edu.unlam.mobile2.mediastackapi.New

data class NewState(
    val news: List<New> = emptyList()
)
