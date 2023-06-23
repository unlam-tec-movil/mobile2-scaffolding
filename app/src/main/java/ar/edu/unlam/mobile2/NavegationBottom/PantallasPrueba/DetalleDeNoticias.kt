package ar.edu.unlam.mobile2.NavegationBottom.PantallasPrueba

import androidx.compose.runtime.Composable
import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile2.mediastackapi.ui.newListDetail
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel


@Composable
fun DetalleDeNoticias(viewModel: NewsViewModel) {
   newListDetail(viewModel)
}

