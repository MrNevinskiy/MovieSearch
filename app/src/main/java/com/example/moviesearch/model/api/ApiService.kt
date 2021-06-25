package com.example.moviesearch.model.api

import com.example.moviesearch.model.repository.description_movie.DescriptionMovie
import com.example.moviesearch.model.repository.list_of_movie.ListOfMovie
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("movie/550?{api_key}")
    suspend fun getListOfMovie(
        @Path("api_key") api_key: String
    ): List<ListOfMovie>

    @GET("search/movie?{api_key}&{query}")
    suspend fun getMovie(
        @Path("api_key") api_key: String,
        @Path("query") query: String
    ): DescriptionMovie

}