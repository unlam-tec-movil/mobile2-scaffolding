package ar.edu.unlam.mobile2.domain.hero

data class Biography(
    val aliases: List<String> = listOf(),
    val alignment: String = "",
    val alterEgos: String = "",
    val firstAppearance: String = "",
    val fullName: String = "",
    val placeOfBirth: String = "",
    val publisher: String = ""
)
