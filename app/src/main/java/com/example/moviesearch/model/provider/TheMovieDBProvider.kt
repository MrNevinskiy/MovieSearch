package com.example.moviesearch.model.provider

import com.example.moviesearch.model.api.ApiService
import com.example.moviesearch.model.repository.description_movie.DescriptionMovie
import com.example.moviesearch.model.repository.list_of_movie.ListOfMovie
import com.example.moviesearch.model.repository.top_movie.TopMovieListy

class TheMovieDBProvider(private val api: ApiService) : ITheMovieDBProvider {

    override suspend fun getListOfMovie(key: String): ListOfMovie =
        api.getListOfMovie(key)


    override suspend fun getMovie(key: String, movie: String): DescriptionMovie =
        api.getMovie(key, movie)

    override suspend fun getTopMovie(key: String): TopMovieListy =
        api.getTopMovie(key)

}