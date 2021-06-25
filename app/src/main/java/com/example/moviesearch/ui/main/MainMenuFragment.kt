package com.example.moviesearch.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.R
import com.example.moviesearch.databinding.FragmentMainMenuBinding
import com.example.moviesearch.model.AppState
import com.example.moviesearch.model.repository.list_of_movie.ListOfMovie
import com.example.moviesearch.ui.adapter.MainMenuAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainMenuFragment: Fragment(R.layout.fragment_main_menu) {

    private val viewModel: MainMenuViewModel by viewModel()
    private lateinit var binding: FragmentMainMenuBinding
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainMenuBinding.bind(view)
        viewModel.subscribe().observe(viewLifecycleOwner, {
            renderData(it)
        })
        navigationInit()

        recyclerView = view.findViewById(R.id.main_fragment_recycler_view)
        viewModel.getListOfMovie()
    }

    private fun navigationInit() {
        binding.findMovie.setOnClickListener {
            findNavController().navigate(R.id.action_mainMenuFragment_to_descriptionFragment,
                null,
                navOptions {
                    anim {
                        enter = android.R.animator.fade_in
                        exit = android.R.animator.fade_out
                    }
                }
            )

        }
    }

    private fun renderData(appState: AppState?) {
        when(appState){
            is AppState.Success<*> -> {
                when(appState.data){
                    is List<*> ->{
                        recyclerView.adapter = MainMenuAdapter(appState.data as List<ListOfMovie>)
                    }
                }
            }
            else -> Toast.makeText(context,"ErrorData", Toast.LENGTH_LONG).show()
        }
    }

}