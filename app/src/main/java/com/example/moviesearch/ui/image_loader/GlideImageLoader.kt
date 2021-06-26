package com.example.moviesearch.ui.image_loader

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import java.io.ByteArrayOutputStream

class GlideImageLoader : IGlideImageLoader<ImageView> {
    override fun loadInto(url: String, container: ImageView) {
        Glide.with(container.context)
            .asBitmap()
            .load(url)
            .listener(object : RequestListener<Bitmap> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return true
                }

                override fun onResourceReady(
                    resource: Bitmap?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    val compressFormat = if (url.contains(".jpg"))
                        Bitmap.CompressFormat.JPEG else Bitmap.CompressFormat.PNG
                    val stream = ByteArrayOutputStream()
                    resource?.compress(compressFormat, 100, stream)
                    return false
                }
            }).into(container)
    }
}
