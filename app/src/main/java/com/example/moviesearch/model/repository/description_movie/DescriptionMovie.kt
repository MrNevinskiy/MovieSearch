package com.example.moviesearch.model.repository.description_movie

import com.google.gson.annotations.SerializedName


data class DescriptionMovie (

    @SerializedName("page") var page : Int,
    @SerializedName("results") var results : List<Results>,
    @SerializedName("total_pages") var totalPages : Int,
    @SerializedName("total_results") var totalResults : Int

)