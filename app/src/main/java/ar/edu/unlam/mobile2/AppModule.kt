package ar.edu.unlam.mobile2

import ar.edu.unlam.mobile2.mediastackapi.repository.MediastackApi
import ar.edu.unlam.mobile2.mediastackapi.repository.NewsRepository
import ar.edu.unlam.mobile2.weatherapi.repository.WeatherApiService
import ar.edu.unlam.mobile2.weatherapi.repository.WeatherStackRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMediaStackApi(): MediastackApi {
        return Retrofit.Builder().baseUrl("http://api.mediastack.com/")
                .addConverterFactory(GsonConverterFactory.create()).client(OkHttpClient.Builder().build())
                .build().create(MediastackApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMediastackRepository(api: MediastackApi): NewsRepository {
        return NewsRepository(api)
    }

    @Provides
    @Singleton
    fun provideWeatherApi (): WeatherApiService {
        return Retrofit.Builder()
            .baseUrl("http://api.weatherstack.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository (api: WeatherApiService): WeatherStackRepository {
        return WeatherStackRepository(api)
    }
}