package com.example.moviesearch.model.repository.list_of_movie

import com.google.gson.annotations.SerializedName


data class ListOfMovie (

    @field:SerializedName("adult") var adult : Boolean,
    @field:SerializedName("backdrop_path") var backdropPath : String,
    @field:SerializedName("belongs_to_collection") var belongsToCollection : String,
    @field:SerializedName("budget") var budget : Int,
    @field:SerializedName("genres") var genres : List<Genres>,
    @field:SerializedName("homepage") var homepage : String,
    @field:SerializedName("id") var id : Int,
    @field:SerializedName("imdb_id") var imdbId : String,
    @field:SerializedName("original_language") var originalLanguage : String,
    @field:SerializedName("original_title") var originalTitle : String,
    @field:SerializedName("overview") var overview : String,
    @field:SerializedName("popularity") var popularity : Double,
    @field:SerializedName("poster_path") var posterPath : String,
    @field:SerializedName("production_companies") var productionCompanies : List<ProductionCompanies>,
    @field:SerializedName("production_countries") var productionCountries : List<ProductionCountries>,
    @field:SerializedName("release_date") var releaseDate : String,
    @field:SerializedName("revenue") var revenue : Int,
    @field:SerializedName("runtime") var runtime : Int,
    @field:SerializedName("spoken_languages") var spokenLanguages : List<SpokenLanguages>,
    @field:SerializedName("status") var status : String,
    @field:SerializedName("tagline") var tagline : String,
    @field:SerializedName("title") var title : String,
    @field:SerializedName("video") var video : Boolean,
    @field:SerializedName("vote_average") var voteAverage : Double,
    @field:SerializedName("vote_count") var voteCount : Int

)