package ar.edu.unlam.mobile2.data

import ar.edu.unlam.mobile2.R
import java.io.Serializable

data class Articulo(
    val id: Int,
    val imagen: Int,
    val titulo: String,
    val autor: String,
    val topic: String
    ): Serializable