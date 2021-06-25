package com.example.moviesearch.ui.description

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.R
import com.example.moviesearch.databinding.FragmentDescriptionBinding
import com.example.moviesearch.model.AppState
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
        recyclerView = view.findViewById(R.id.description_recycler_view)
    }

    private fun renderData(appState: AppState?) {
        TODO("Not yet implemented")
    }

}

