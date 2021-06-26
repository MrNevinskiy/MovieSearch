package com.example.moviesearch.di

import android.widget.ImageView
import com.example.moviesearch.model.provider.ITheMovieDBProvider
import com.example.moviesearch.model.provider.TheMovieDBProvider
import com.example.moviesearch.model.retrofit.RetrofitImplementation
import com.example.moviesearch.ui.description.DescriptionViewModel
import com.example.moviesearch.ui.image_loader.GlideImageLoader
import com.example.moviesearch.ui.image_loader.IGlideImageLoader
import com.example.moviesearch.ui.main.MainMenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { RetrofitImplementation().createRetrofit() }
    single<ITheMovieDBProvider> { TheMovieDBProvider(get()) }
    factory<IGlideImageLoader<ImageView>> { GlideImageLoader() }
}

val mainMenuFragmenttModule = module {
    viewModel { MainMenuViewModel(get()) }
}

val descriptionFragmentModule = module {
    viewModel { DescriptionViewModel(get()) }
}
