package com.example.moviesearch.model.api

import com.example.moviesearch.model.repository.description_movie.DescriptionMovie
import com.example.moviesearch.model.repository.list_of_movie.ListOfMovie
import com.example.moviesearch.model.repository.top_movie.TopMovieListy
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/550?")
    suspend fun getListOfMovie(
        @Query("api_key") api_key: String
    ): ListOfMovie

    @GET("search/movie?")
    suspend fun getMovie(
        @Query("api_key") api_key: String,
        @Query("query") query: String
    ): DescriptionMovie

    @GET("/movie/top_rated?")
    suspend fun getTopMovie(
        @Query("api_key") api_key: String
    ): TopMovieListy

}