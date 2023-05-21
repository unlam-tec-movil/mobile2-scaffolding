package com.example.apinoticias.PruebaBasica

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Modulo {
    @Provides
    @Singleton
    fun inyectarApi ():WeatherApiService{
        return Retrofit.Builder()
            .baseUrl("http://api.weatherstack.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }
    @Provides
    @Singleton
    fun provideRepository (api:WeatherApiService):WeatherStackRepository{
        return WeatherStackRepository(api)
    }
}

