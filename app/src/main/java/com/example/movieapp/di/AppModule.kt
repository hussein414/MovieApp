package com.example.movieapp.di

import com.example.movieapp.data.client.TvShowsApiService
import com.example.movieapp.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesBaseurl() = Constant.BASE_URL

    @Provides
    @Singleton
    fun providesRetrofitInstance(BASE_URL: String): TvShowsApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TvShowsApiService::class.java)
}