package ar.edu.unlam.mobile2.data



import androidx.compose.runtime.Composable

import ar.edu.unlam.mobile2.domain.AppContainer


@Composable
fun General(){
    AppContainer(ArticuloRepository.articulos)
}

@Composable
fun Politica() {
    AppContainer(ArticuloRepository.articulos.filter {s: Articulo -> s.topic.equals("Politica")})
}

@Composable
fun Musica() {
    AppContainer(ArticuloRepository.articulos.filter {s: Articulo -> s.topic.equals("Musica")})
}

