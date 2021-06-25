package com.example.moviesearch

import android.app.Application
import com.example.moviesearch.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieSearchApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    appModule,
                    mainMenuFragmenttModule,
                    descriptionFragmentModule
                )
            )
        }
    }
}