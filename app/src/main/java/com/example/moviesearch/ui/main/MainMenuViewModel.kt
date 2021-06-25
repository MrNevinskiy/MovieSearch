package com.example.moviesearch.ui.main

import androidx.lifecycle.LiveData
import com.example.moviesearch.BuildConfig
import com.example.moviesearch.model.AppState
import com.example.moviesearch.model.provider.ITheMovieDBProvider
import com.example.moviesearch.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MainMenuViewModel(val iTheMovieDBProvider: ITheMovieDBProvider) : BaseViewModel<AppState>() {

    fun subscribe(): LiveData<AppState> = liveDataViewModel

    fun getListOfMovie() {
        viewModelCoroutineScope.launch {
            liveDataViewModel.value =
                AppState.Success(iTheMovieDBProvider.getListOfMovie(BuildConfig.MOVIE_API_KEY))
        }
    }

    fun findMovieByName(name: String) {
        viewModelCoroutineScope.launch {
            liveDataViewModel.value = AppState.Success(
                iTheMovieDBProvider.getMovie(
                    BuildConfig.MOVIE_API_KEY,
                    name
                )
            )
        }
    }

    override fun errorReturned(t: Throwable) {
        println(t.message.toString())
    }
}