package ar.edu.unlam.mobile2.Tabs.repository



import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ar.edu.unlam.mobile2.mediastackapi.ui.NewsList
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel


@Composable
fun General(viewModel: NewsViewModel){
    NewsList(viewModel)
}


@Composable
fun Politica() {
    Column() {
        Text(text = "POLITICA")
    }
}

@Composable
fun Musica() {
    Column() {
        Text(text = "MUSICA")
    }
}

