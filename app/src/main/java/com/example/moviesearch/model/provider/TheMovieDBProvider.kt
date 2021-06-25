package com.example.moviesearch.model.provider

import com.example.moviesearch.model.api.ApiService

class TheMovieDBProvider(private val api: ApiService) : ITheMovieDBProvider {

    override suspend fun getListOfMovie(key: String) {
        api.getListOfMovie(key)
    }

    override suspend fun getMovie(key: String, movie: String) {
        api.getMovie(key,movie)
    }
}