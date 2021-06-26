package com.example.moviesearch.model.provider

import com.example.moviesearch.model.repository.description_movie.DescriptionMovie
import com.example.moviesearch.model.repository.list_of_movie.ListOfMovie
import com.example.moviesearch.model.repository.top_movie.TopMovieListy

interface ITheMovieDBProvider{

    suspend fun getListOfMovie(key: String): ListOfMovie
    suspend fun getMovie(key: String, movie: String): DescriptionMovie
    suspend fun getTopMovie(key: String): TopMovieListy


}