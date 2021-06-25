package com.example.moviesearch.model.repository.list_of_movie

import com.google.gson.annotations.SerializedName


data class Genres (

    @SerializedName("id") var id : Int,
    @SerializedName("name") var name : String

)