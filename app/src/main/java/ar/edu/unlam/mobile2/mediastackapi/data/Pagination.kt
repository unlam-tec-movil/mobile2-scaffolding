package ar.edu.unlam.mobile2.mediastackapi.data


import com.google.gson.annotations.SerializedName
import retrofit2.http.Query

data class Pagination(
    @Query("count")
    val count: Int,
    @Query("limit")
    val limit: Int,
    @Query("offset")
    val offset: Int,
    @Query("total")
    val total: Int
)