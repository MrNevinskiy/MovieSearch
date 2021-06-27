package com.example.moviesearch.model.provider

import com.example.moviesearch.model.repository.billed_cast.BilledCast
import com.example.moviesearch.model.repository.description_movie.DescriptionMovie
import com.example.moviesearch.model.repository.top_movie.TopMovieListy

interface ITheMovieDBProvider{

    suspend fun getBilledCast(key: String, id: Int): BilledCast
    suspend fun getMovie(key: String, movie: String): DescriptionMovie
    suspend fun getTopMovie(key: String): TopMovieListy


}