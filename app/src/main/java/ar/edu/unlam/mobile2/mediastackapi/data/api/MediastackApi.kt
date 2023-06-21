package ar.edu.unlam.mobile2.mediastackapi.data.api

import ar.edu.unlam.mobile2.mediastackapi.data.api.response.NewsResponse
import retrofit2.http.GET

interface MediastackApi {

    @GET("v1/news?access_key=33597a00a28ca90e3e5ac791b76b3e6e" +
            "&limit=100")
    suspend fun getNews(
    ): NewsResponse
}