package ar.edu.unlam.mobile2.mediastackapi

import android.provider.MediaStore.Audio.Media
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
    fun provideMediaStackApi(): MediastackApi{
        return Retrofit.Builder().baseUrl("http://api.mediastack.com/")
                .addConverterFactory(GsonConverterFactory.create()).client(OkHttpClient.Builder().build())
                .build().create(MediastackApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: MediastackApi): NewsRepository{
        return NewsRepository(api)
    }
}