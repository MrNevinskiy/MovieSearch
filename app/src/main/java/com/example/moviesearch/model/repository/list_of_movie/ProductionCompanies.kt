package com.example.moviesearch.model.repository.list_of_movie


import com.google.gson.annotations.SerializedName


data class ProductionCompanies (

    @field:SerializedName("id") var id : Int,
    @field:SerializedName("logo_path") var logoPath : String,
    @field:SerializedName("name") var name : String,
    @field:SerializedName("origin_country") var originCountry : String

)