package com.example.movieapp.data.event

import com.example.movieapp.data.model.TVShowsItem

interface ItemTvShowClickListener {
    fun onItemClick(model: TVShowsItem)
}