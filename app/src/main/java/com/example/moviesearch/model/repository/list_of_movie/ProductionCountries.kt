package com.example.moviesearch.model.repository.list_of_movie

import com.google.gson.annotations.SerializedName


data class ProductionCountries (

    @field:SerializedName("iso_3166_1") var iso31661 : String,
    @field:SerializedName("name") var name : String

)