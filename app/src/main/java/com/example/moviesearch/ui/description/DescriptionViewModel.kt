package com.example.moviesearch.ui.description

import androidx.lifecycle.LiveData
import com.example.moviesearch.BuildConfig
import com.example.moviesearch.model.AppState
import com.example.moviesearch.model.provider.ITheMovieDBProvider
import com.example.moviesearch.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class DescriptionViewModel(val iTheMovieDBProvider: ITheMovieDBProvider) :
    BaseViewModel<AppState>() {

    fun subscribe(): LiveData<AppState> = liveDataViewModel

    fun getMovieByID(name: String) {
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