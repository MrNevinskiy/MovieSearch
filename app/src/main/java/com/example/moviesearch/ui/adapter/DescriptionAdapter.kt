package com.example.moviesearch.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.model.repository.description_movie.DescriptionMovie
import com.example.moviesearch.ui.adapter.DescriptionAdapter.DescriptionAdapterHV

class DescriptionAdapter(private val descriptionMovie: DescriptionMovie): RecyclerView.Adapter<DescriptionAdapterHV>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionAdapterHV {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: DescriptionAdapterHV, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class DescriptionAdapterHV (itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}