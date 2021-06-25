package com.example.moviesearch.model.provider

interface ITheMovieDBProvider{

    suspend fun getListOfMovie(key: String)
    suspend fun getMovie(key: String, movie: String)

}