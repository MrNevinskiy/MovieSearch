package com.example.moviesearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.R
import com.example.moviesearch.model.repository.billed_cast.BilledCast
import com.example.moviesearch.ui.adapter.DescriptionAdapter.DescriptionAdapterHV
import com.example.moviesearch.ui.image_loader.IGlideImageLoader
import org.koin.java.KoinJavaComponent.inject

class DescriptionAdapter(private val billedCast: BilledCast): RecyclerView.Adapter<DescriptionAdapterHV>() {

    private val iGlideImageLoader: IGlideImageLoader<ImageView> by inject(
        IGlideImageLoader::class.java
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionAdapterHV {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_billed_cast_rv, parent, false)
        return DescriptionAdapterHV(itemView)
    }

    override fun onBindViewHolder(holder: DescriptionAdapterHV, position: Int) {
        holder.nameHero?.text = billedCast.cast[position].character
        holder.realName?.text = billedCast.cast[position].originalName
        if (billedCast.cast[position].profilePath != null){
            holder.avatar?.let { billedCast.cast[position].profilePath?.let { it1 ->
                iGlideImageLoader.loadInto(
                    it1, it)
            } }
        }

    }

    override fun getItemCount(): Int = billedCast.cast.size

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