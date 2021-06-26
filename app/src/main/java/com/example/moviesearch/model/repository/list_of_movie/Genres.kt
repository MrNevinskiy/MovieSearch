package com.example.moviesearch.model.repository.list_of_movie

import com.google.gson.annotations.SerializedName


data class Genres (

    @field:SerializedName("id") var id : Int,
    @field:SerializedName("name") var name : String

)