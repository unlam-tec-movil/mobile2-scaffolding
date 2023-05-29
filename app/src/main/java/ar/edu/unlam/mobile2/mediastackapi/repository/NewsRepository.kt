package ar.edu.unlam.mobile2.mediastackapi.repository

import ar.edu.unlam.mobile2.mediastackapi.data.Data
import java.lang.Exception

class NewsRepository(
    private val api: MediastackApi
) {
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