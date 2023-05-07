package ar.edu.unlam.mobile2.domain.hero

data class DataHero(
    val appearance: Appearance = Appearance(),
    val biography: Biography = Biography(),
    val connections: Connections = Connections(),
    val id: String = "",
    val image: Image = Image(),
    val name: String = "",
    val powerstats: Powerstats = Powerstats(),
    val response: String = "",
    val work: Work = Work(),
    val isFavorite: Boolean = false
)