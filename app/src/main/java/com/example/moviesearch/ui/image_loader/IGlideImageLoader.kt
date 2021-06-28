package com.example.moviesearch.ui.image_loader

interface IGlideImageLoader<T> {
    fun loadInto(url: String, container: T)
}