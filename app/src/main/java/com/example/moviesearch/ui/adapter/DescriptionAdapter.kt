package com.example.moviesearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.R
import com.example.moviesearch.model.repository.description_movie.DescriptionMovie
import com.example.moviesearch.ui.adapter.DescriptionAdapter.DescriptionAdapterHV
import com.example.moviesearch.ui.image_loader.IGlideImageLoader

class DescriptionAdapter(private val descriptionMovie: DescriptionMovie): RecyclerView.Adapter<DescriptionAdapterHV>() {

    private lateinit var imageLoader: IGlideImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionAdapterHV {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_billed_cast_rv, parent, false)
        return DescriptionAdapterHV(itemView)
    }

    override fun onBindViewHolder(holder: DescriptionAdapterHV, position: Int) {
        // TODO: 27.06.2021  
    }

    override fun getItemCount(): Int = descriptionMovie.results.size

    inner class DescriptionAdapterHV (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var avatar: ImageView? = null
        var nameHero: TextView? = null
        var realName: TextView? = null

        init {
            avatar = itemView.findViewById(R.id.top_billed_cast_avatar_rv)
            nameHero = itemView.findViewById(R.id.top_billed_cast_name_hero_rv)
            realName = itemView.findViewById(R.id.top_billed_cast_real_name_rv)
        }
    }
}