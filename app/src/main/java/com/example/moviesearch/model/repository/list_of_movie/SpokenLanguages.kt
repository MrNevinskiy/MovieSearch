package com.example.moviesearch.model.repository.list_of_movie

import com.google.gson.annotations.SerializedName


data class SpokenLanguages (

    @field:SerializedName("english_name") var englishName : String,
    @field:SerializedName("iso_639_1") var iso6391 : String,
    @field:SerializedName("name") var name : String

)