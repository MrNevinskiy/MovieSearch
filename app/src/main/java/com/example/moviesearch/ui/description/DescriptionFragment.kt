package com.example.moviesearch.ui.description

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.R
import com.example.moviesearch.databinding.FragmentDescriptionBinding
import com.example.moviesearch.model.AppState
import com.example.moviesearch.model.repository.billed_cast.BilledCast
import com.example.moviesearch.model.repository.description_movie.DescriptionMovie
import com.example.moviesearch.ui.adapter.DescriptionAdapter
import com.example.moviesearch.ui.image_loader.IGlideImageLoader
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.java.KoinJavaComponent

class DescriptionFragment : Fragment(R.layout.fragment_description) {

    private val viewModel: DescriptionViewModel by viewModel()
    private lateinit var binding: FragmentDescriptionBinding
    private lateinit var recyclerView: RecyclerView
    private val args: DescriptionFragmentArgs by navArgs()

    private val imageLoader: IGlideImageLoader<ImageView> by KoinJavaComponent.inject(
        IGlideImageLoader::class.java
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDescriptionBinding.bind(view)
        viewModel.subscribe().observe(viewLifecycleOwner, {
            renderData(it)
        })
        init(view)

    }

    private fun init(view: View) {
        args.queryMovie?.let {
            viewModel.getMovieByID(it)
        }
        recyclerView = view.findViewById(R.id.description_recycler_view)
    }


    private fun initPage(data: DescriptionMovie) {
        viewModel.getBilledCast(data.results[0].id)
        binding.descriptionAvatarImgRv.let { imageLoader.loadInto(data.results[0].posterPath, it) }
        binding.descriptionBackImgRv.let { imageLoader.loadInto(data.results[0].backdropPath, it) }
        binding.descriptionScoreRv.text = data.results[0].voteAverage.toString()
        binding.descriptionTitleRv.text = data.results[0].title
        binding.descriptionReleaseDateRv.text = data.results[0].releaseDate
        binding.descriptionTimeRv.text //todo
        binding.descriptionGenreRv.text //todo
        binding.descriptionAboutRv.text = data.results[0].overview
    }

    private fun renderData(appState: AppState?) {
        when (appState) {
            is AppState.Success<*> -> {
                when (appState.data) {
                    is DescriptionMovie -> {
                        initPage(appState.data)
                    }
                    is BilledCast -> {
                        recyclerView.adapter = DescriptionAdapter(appState.data)
                    }
                }
            }
            else -> Toast.makeText(context, "ErrorData", Toast.LENGTH_LONG).show()
        }
    }

}

