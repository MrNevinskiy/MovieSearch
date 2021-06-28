package com.example.moviesearch.model.repository.billed_cast


import com.google.gson.annotations.SerializedName

data class BilledCast(
    @SerializedName("cast")
    val cast: List<Cast>,
    @SerializedName("crew")
    val crew: List<Crew>,
    @SerializedName("id")
    val id: Int
)