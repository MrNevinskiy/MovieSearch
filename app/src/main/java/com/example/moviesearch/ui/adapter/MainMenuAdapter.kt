package com.example.moviesearch.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.model.repository.list_of_movie.ListOfMovie
import com.example.moviesearch.ui.adapter.MainMenuAdapter.MainMenuAdapterVH

class MainMenuAdapter(private val list: List<ListOfMovie>): RecyclerView.Adapter<MainMenuAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuAdapterVH {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MainMenuAdapterVH, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = list.size

    inner class MainMenuAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}