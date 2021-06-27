package com.example.moviesearch.model.provider

import com.example.moviesearch.model.api.ApiService
import com.example.moviesearch.model.repository.billed_cast.BilledCast
import com.example.moviesearch.model.repository.description_movie.DescriptionMovie
import com.example.moviesearch.model.repository.top_movie.TopMovieListy

class TheMovieDBProvider(private val api: ApiService) : ITheMovieDBProvider {

    override suspend fun getBilledCast(key: String, id: Int): BilledCast =
        api.getBilledCast(id, key)


    override suspend fun getMovie(key: String, movie: String): DescriptionMovie =
        api.getMovie(key, movie)

    override suspend fun getTopMovie(key: String): TopMovieListy =
        api.getTopMovie(key)

}