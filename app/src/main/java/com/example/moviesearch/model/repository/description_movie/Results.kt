package com.example.moviesearch.model.repository.description_movie

import com.google.gson.annotations.SerializedName


data class Results (

    @field:SerializedName("adult") var adult : Boolean,
    @field:SerializedName("backdrop_path") var backdropPath : String,
    @field:SerializedName("genre_ids") var genreIds : List<Int>,
    @field:SerializedName("id") var id : Int,
    @field:SerializedName("original_language") var originalLanguage : String,
    @field:SerializedName("original_title") var originalTitle : String,
    @field:SerializedName("overview") var overview : String,
    @field:SerializedName("popularity") var popularity : Double,
    @field:SerializedName("poster_path") var posterPath : String,
    @field:SerializedName("release_date") var releaseDate : String,
    @field:SerializedName("title") var title : String,
    @field:SerializedName("video") var video : Boolean,
    @field:SerializedName("vote_average") var voteAverage : Double,
    @field:SerializedName("vote_count") var voteCount : Int

)