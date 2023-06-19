package ar.edu.unlam.mobile2.Tabs.repository


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ar.edu.unlam.mobile2.mediastackapi.ui.NewsList
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel


@Composable
fun General(viewModel: NewsViewModel) {
    NewsList(viewModel, 1)
}


@Composable
fun Business(viewModel: NewsViewModel) {
    NewsList(viewModel, 2)
}

@Composable
fun Entertainment(viewModel: NewsViewModel) {
    NewsList(viewModel, 3)
}

@Composable
fun Health(viewModel: NewsViewModel) {
    NewsList(viewModel, 4)
}

@Composable
fun Science(viewModel: NewsViewModel) {
    NewsList(viewModel, 5)
}

@Composable
fun Sports(viewModel: NewsViewModel) {
    NewsList(viewModel, 6)
}

@Composable
fun Technology(viewModel: NewsViewModel) {
    NewsList(viewModel, 7)
}





