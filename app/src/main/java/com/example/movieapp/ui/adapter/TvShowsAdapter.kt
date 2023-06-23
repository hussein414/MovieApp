package com.example.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.data.event.ItemTvShowClickListener
import com.example.movieapp.data.model.TVShowsItem
import com.example.movieapp.databinding.ItemViewBinding


class TvShowsAdapter(val listener: ItemTvShowClickListener) :
    RecyclerView.Adapter<TvShowViewHolder>() {
    private val diffCallBack = object : DiffUtil.ItemCallback<TVShowsItem>() {
        override fun areItemsTheSame(oldItem: TVShowsItem, newItem: TVShowsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TVShowsItem, newItem: TVShowsItem): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)


    var tvShowsModel: List<TVShowsItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bindViews(tvShowsModel[position],listener)
    }

    override fun getItemCount(): Int = tvShowsModel.size
}