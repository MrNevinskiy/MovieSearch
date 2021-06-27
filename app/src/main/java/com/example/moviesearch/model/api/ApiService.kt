package com.example.moviesearch.model.api

import com.example.moviesearch.model.repository.billed_cast.BilledCast
import com.example.moviesearch.model.repository.description_movie.DescriptionMovie
import com.example.moviesearch.model.repository.top_movie.TopMovieListy
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/{id}/credits?")
    suspend fun getBilledCast(
        @Path("id")  id_key: Int, @Query("api_key") api_key: String
    ): BilledCast

    @GET("search/movie?")
    suspend fun getMovie(
        @Query("api_key") api_key: String,
        @Query("query") query: String
    ): DescriptionMovie

    @GET("movie/top_rated?")
    suspend fun getTopMovie(
        @Query("api_key") api_key: String
    ): TopMovieListy

}