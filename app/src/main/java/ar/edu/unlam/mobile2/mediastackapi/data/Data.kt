package ar.edu.unlam.mobile2.mediastackapi.data


import com.google.gson.annotations.SerializedName
import retrofit2.http.Query

data class Data(
    @Query("author")
    val author: String,
    @Query("category")
    val category: String,
    @Query("country")
    val country: String,
    @Query("description")
    val description: String,
    @Query("image")
    val image: String,
    @Query("language")
    val language: String,
    @Query("published_at")
    val publishedAt: String = "01/01/0001",
    @Query("source")
    val source: String,
    @Query("title")
    val title: String,
    @Query("url")
    val url: String
)