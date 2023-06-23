package com.example.movieapp.data.repository

import com.example.movieapp.data.client.TvShowsApiService
import javax.inject.Inject

class TvShowsRepository @Inject constructor(private val apiService: TvShowsApiService) {
    suspend fun getTvShows() = apiService.getTvShows()
}