package com.example.moviesearch.ui.description

import android.os.Bundle
import android.view.View
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
import org.koin.androidx.viewmodel.ext.android.viewModel

class DescriptionFragment : Fragment(R.layout.fragment_description) {

    private val viewModel: DescriptionViewModel by viewModel()
    private lateinit var binding: FragmentDescriptionBinding
    private lateinit var recyclerView: RecyclerView
    private val args: DescriptionFragmentArgs by navArgs()

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


    private fun renderData(appState: AppState?) {
        when (appState) {
            is AppState.Success<*> -> {
                when (appState.data) {
                    is DescriptionMovie -> {
                        recyclerView.adapter = DescriptionAdapter(appState.data)
                        binding.descriptionTitleRv.text = appState.data.results[0].title
                        binding.descriptionReleaseRv.text = appState.data.results[0].releaseDate
                    }
                }
            }
            else -> Toast.makeText(context, "ErrorData", Toast.LENGTH_LONG).show()
        }
    }

}

