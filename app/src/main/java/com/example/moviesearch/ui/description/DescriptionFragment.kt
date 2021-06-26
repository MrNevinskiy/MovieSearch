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
import com.example.moviesearch.model.repository.description_movie.DescriptionMovie
import com.example.moviesearch.ui.adapter.DescriptionAdapter
import com.example.moviesearch.ui.image_loader.IGlideImageLoader
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class DescriptionFragment : Fragment(R.layout.fragment_description) {

    private val viewModel: DescriptionViewModel by viewModel()
    private lateinit var binding: FragmentDescriptionBinding
    private lateinit var recyclerView: RecyclerView
    private val args: DescriptionFragmentArgs by navArgs()

    private lateinit var imageLoader: IGlideImageLoader<ImageView>

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
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


    private fun initPage(data: DescriptionMovie) {
        binding.descriptionAvatarImgRv.let { imageLoader.loadInto(data.results[0].posterPath, it) }
        binding.descriptionBackImgRv.let { imageLoader.loadInto(data.results[0].backdropPath, it) }
        //rating
        binding.descriptionTitleRv.text = data.results[0].title
        binding.descriptionReleaseRv.text = data.results[0].releaseDate
        //time
        //genre
        binding.descriptionAboutRv.text = data.results[0].overview
    }

    private fun renderData(appState: AppState?) {
        when (appState) {
            is AppState.Success<*> -> {
                when (appState.data) {
                    is DescriptionMovie -> {
                        recyclerView.adapter = DescriptionAdapter(appState.data)
                        initPage(appState.data)

                    }
                }
            }
            else -> Toast.makeText(context, "ErrorData", Toast.LENGTH_LONG).show()
        }
    }

}

