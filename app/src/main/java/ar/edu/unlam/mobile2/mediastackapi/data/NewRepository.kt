package ar.edu.unlam.mobile2.mediastackapi.data

import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile2.mediastackapi.data.api.MediastackApi
import ar.edu.unlam.mobile2.mediastackapi.data.local.NewDao
import ar.edu.unlam.mobile2.mediastackapi.data.mapper.toDomain
import ar.edu.unlam.mobile2.mediastackapi.data.mapper.toEntity
import java.lang.Exception

class NewRepository(
    private val api: MediastackApi,
    private val dao: NewDao
) {

    suspend fun getNews(): List<New> {
        var localNews = dao.getNews()

        if(localNews.isEmpty()){
            val newsFromApi = getNewsFromApi()

            newsFromApi.forEach {
                dao.insertNew(it.toEntity())
            }
            localNews = dao.getNews()
        }
        return localNews.map { it.toDomain() }
    }


    suspend fun getNewsFromApi(): List<New> {
        return try {
            val response = api.getNews()
            val responseNews = response.data.map { it.toDomain() }
            responseNews
        } catch (e: Exception) {
            return emptyList()
        }
    }
}