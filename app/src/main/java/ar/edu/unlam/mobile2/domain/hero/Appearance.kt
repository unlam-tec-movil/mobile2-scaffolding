package ar.edu.unlam.mobile2.domain.hero

data class Appearance(
    val eyeColor: String = "",
    val gender: String = "",
    val hairColor: String = "",
    val height: List<String> = listOf(),
    val race: String = "",
    val weight: List<String> = listOf()
)
