package ar.edu.unlam.mobile2.data

interface KittiesRepo {

    suspend fun getNewKitty():String

}