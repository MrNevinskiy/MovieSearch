package com.example.moviesearch.model.retrofit

import com.example.moviesearch.model.api.ApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitImplementation {

    fun createRetrofit(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_LOCATIONS)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(ApiService::class.java)
    }

    companion object {
        private const val BASE_URL_LOCATIONS = "https://api.themoviedb.org/3/"
    }

}