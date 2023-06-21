package ar.edu.unlam.mobile2.NavegationBottom.PantallasPrueba


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import ar.edu.unlam.mobile2.mediastackapi.ui.SavedNewsList
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel

@Composable

fun Favorito(viewModel: NewsViewModel) {
    SavedNewsList(viewModel)

}

