package ar.edu.unlam.mobile2.data

import ar.edu.unlam.mobile2.R

object ArticuloRepository {

    val articulos: List<Articulo> = listOf(
        Articulo(
            1,
            R.drawable.ic_launcher_background,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            "Autor",
            "Politica"
        ),
        Articulo(2, R.drawable.ic_launcher_background, "Titulo 2", "Autor", "Musica"),
        Articulo(3, R.drawable.ic_launcher_background, "Titulo 3", "Autor", "Economia"),
        Articulo(4, R.drawable.ic_launcher_background, "Titulo 4", "Autor", "Deporte"),
        Articulo(5, R.drawable.ic_launcher_background, "Titulo 5", "Autor", "Politica"),
        Articulo(6, R.drawable.ic_launcher_background, "Titulo 6", "Autor", "Deporte"),
        Articulo(7, R.drawable.ic_launcher_background, "Titulo 7", "Autor", "Musica"),
        Articulo(8, R.drawable.ic_launcher_background, "Titulo 8", "Autor", "Politica"),
        Articulo(9, R.drawable.ic_launcher_background, "Titulo 9", "Autor", "Economia"),
        Articulo(10, R.drawable.ic_launcher_background, "Titulo 10", "Autor", "Politica"),
    )
}