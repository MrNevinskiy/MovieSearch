package com.example.moviesearch.model.repository.description_movie

import com.google.gson.annotations.SerializedName


data class DescriptionMovie (

    @field:SerializedName("page") var page : Int,
    @field:SerializedName("results") var results : List<Results>,
    @field:SerializedName("total_pages") var totalPages : Int,
    @field:SerializedName("total_results") var totalResults : Int

)