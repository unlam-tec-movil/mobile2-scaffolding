package ar.edu.unlam.mobile2.data

import ar.edu.unlam.mobile2.domain.Kitty

data class KittyApiModel(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int,
)

fun KittyApiModel.toModel() = Kitty(
    id = id,
    url = url,
    width = width,
    height = height,
)
