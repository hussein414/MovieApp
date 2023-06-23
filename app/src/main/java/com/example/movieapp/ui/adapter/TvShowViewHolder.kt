package com.example.movieapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.movieapp.data.event.ItemTvShowClickListener
import com.example.movieapp.data.model.TVShowsItem
import com.example.movieapp.databinding.ItemViewBinding
import com.squareup.picasso.Picasso

class TvShowViewHolder(private val binding: ItemViewBinding) : ViewHolder(binding.root) {
    fun bindViews(model: TVShowsItem, listener: ItemTvShowClickListener) {
        binding.rate.text = model.rating.average.toString()
        Picasso.get().load(model.image.original).into(binding.imageMovie)
        binding.parent.setOnClickListener {
            listener.onItemClick(model)
        }

    }
}