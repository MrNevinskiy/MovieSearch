package com.example.moviesearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.R
import com.example.moviesearch.model.repository.top_movie.TopMovieListy
import com.example.moviesearch.ui.adapter.MainMenuAdapter.MainMenuAdapterVH
import com.example.moviesearch.ui.image_loader.IGlideImageLoader
import com.example.moviesearch.ui.main.MainMenuFragmentDirections
import org.koin.java.KoinJavaComponent.inject

class MainMenuAdapter(private val list: TopMovieListy) : RecyclerView.Adapter<MainMenuAdapterVH>() {

    private val iGlideImageLoader: IGlideImageLoader<ImageView> by inject(IGlideImageLoader::class.java)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuAdapterVH {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_rv, parent, false)
        return MainMenuAdapterVH(itemView)
    }

    override fun onBindViewHolder(holder: MainMenuAdapterVH, position: Int) {
        var avatarUrl = list.results[position].posterPath
        holder.mainAvatar?.let { iGlideImageLoader.loadInto(avatarUrl, it) }

        holder.about?.text = list.results[position].title
        holder.title?.text = list.results[position].originalTitle
        holder.mainAvatar?.setOnClickListener { view ->
            view.findNavController().navigate(
                MainMenuFragmentDirections.actionMainMenuFragmentToDescriptionFragment(list.results[position].title)
            )
        }
    }

    override fun getItemCount(): Int = list.results.size

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

    companion object {
        val URL: String = "https://image.tmdb.org/t/p/w500"
    }
}