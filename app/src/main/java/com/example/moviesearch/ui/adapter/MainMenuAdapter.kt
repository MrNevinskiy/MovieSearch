package com.example.moviesearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.R
import com.example.moviesearch.model.repository.list_of_movie.ListOfMovie
import com.example.moviesearch.ui.adapter.MainMenuAdapter.MainMenuAdapterVH
import com.example.moviesearch.ui.image_loader.IGlideImageLoader
import com.example.moviesearch.ui.main.MainMenuFragmentDirections

class MainMenuAdapter(private val list: ListOfMovie) : RecyclerView.Adapter<MainMenuAdapterVH>(){

    private lateinit var imageLoader: IGlideImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuAdapterVH {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_rv, parent, false)
        return MainMenuAdapterVH(itemView)
    }

    override fun onBindViewHolder(holder: MainMenuAdapterVH, position: Int) {
        var avatar_url = list.productionCompanies[position].logoPath

        holder.about?.text = list.productionCompanies[position].name
        holder.title?.text = list.productionCompanies[position].originCountry
        holder.mainAvatar?.let { imageLoader.loadInto(avatar_url, it) }
        holder.mainAvatar?.setOnClickListener { view ->
            view.findNavController().navigate(
                MainMenuFragmentDirections.actionMainMenuFragmentToDescriptionFragment(list.productionCompanies[position].name)
            )
        }
    }

    override fun getItemCount(): Int = list.productionCompanies.size

    inner class MainMenuAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var about: TextView? = null
        var title: TextView? = null
        var mainRating: ImageView? = null
        var mainAvatar: ImageView? = null

        init {
            about = itemView.findViewById(R.id.main_about_rv)
            title = itemView.findViewById(R.id.main_title_rv)
            mainRating = itemView.findViewById(R.id.main_rating_rv)
            mainAvatar = itemView.findViewById(R.id.main_avatar_rv)
        }
    }
}