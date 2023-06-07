package ar.edu.unlam.mobile2.data

import kotlinx.coroutines.flow.Flow


interface KittiesRepo {

    suspend fun getNewKittyUrl(): String

    suspend fun getNewKitty(): Flow<KittyApiModel>
}
