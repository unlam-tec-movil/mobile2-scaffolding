package ar.edu.unlam.mobile2.mediastackapi.data


import retrofit2.http.Query

data class NewsResponse(
    @Query("data")
    val data: List<Data>,
    @Query("pagination")
    val pagination: Pagination
)