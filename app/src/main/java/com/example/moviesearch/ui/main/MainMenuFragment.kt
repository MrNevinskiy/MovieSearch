package com.example.moviesearch.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.R
import com.example.moviesearch.databinding.FragmentMainMenuBinding
import com.example.moviesearch.model.AppState
import com.example.moviesearch.model.repository.top_movie.TopMovieListy
import com.example.moviesearch.ui.adapter.MainMenuAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainMenuFragment : Fragment(R.layout.fragment_main_menu) {

    private val viewModel: MainMenuViewModel by viewModel()
    private lateinit var binding: FragmentMainMenuBinding
    private lateinit var recyclerView: RecyclerView
    private var query: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainMenuBinding.bind(view)
        viewModel.subscribe().observe(viewLifecycleOwner, {
            renderData(it)
        })
        init(view)
    }

    private fun toDescriptionScreen() {
        findNavController().navigate(MainMenuFragmentDirections.actionMainMenuFragmentToDescriptionFragment(
            query
        ),
            navOptions {
                anim {
                    enter = android.R.animator.fade_in
                    exit = android.R.animator.fade_out
                }
            })
    }

    private fun init(view: View) {
        viewModel.getTopMovie()
        recyclerView = view.findViewById(R.id.main_fragment_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.findMovie.setOnClickListener {
            query = binding.editTextMovie.text.toString()
            toDescriptionScreen()
        }
    }

    private fun renderData(appState: AppState?) {
        when (appState) {
            is AppState.Success<*> -> {
                when (appState.data) {
                    is TopMovieListy -> {
                        recyclerView.adapter = MainMenuAdapter(appState.data)
                    }
                }
            }
            else -> Toast.makeText(context, "ErrorData", Toast.LENGTH_LONG).show()
        }
    }

}