package ar.edu.unlam.mobile2.mediastackapi

import ar.edu.unlam.mobile2.mediastackapi.data.Data
import java.lang.Exception

class NewsRepository(
    private val api: MediastackApi
) {
    //private val accessKey = "5e48b03cc3ee66a83b4478052ef16fb3"
    suspend fun getNews(
    ): Result<List<Data>> {
        return try {
            val response = api.getNews().data
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}