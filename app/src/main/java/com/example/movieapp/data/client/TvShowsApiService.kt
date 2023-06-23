package com.example.movieapp.data.client

import com.example.movieapp.data.model.TVShowsRespons
import com.example.movieapp.utils.Constant
import retrofit2.Response
import retrofit2.http.GET

interface TvShowsApiService {

    @GET(Constant.END_POINT)
    suspend fun getTvShows():Response<TVShowsRespons>
}