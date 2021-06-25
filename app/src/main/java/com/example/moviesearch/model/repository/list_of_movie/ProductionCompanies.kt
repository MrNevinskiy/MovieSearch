package com.example.moviesearch.model.repository.list_of_movie


import com.google.gson.annotations.SerializedName


data class ProductionCompanies (

    @SerializedName("id") var id : Int,
    @SerializedName("logo_path") var logoPath : String,
    @SerializedName("name") var name : String,
    @SerializedName("origin_country") var originCountry : String

)