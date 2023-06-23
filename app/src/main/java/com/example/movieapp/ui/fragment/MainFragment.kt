package com.example.movieapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.data.event.ItemTvShowClickListener
import com.example.movieapp.data.model.TVShowsItem
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.databinding.FragmentMainBinding
import com.example.movieapp.ui.adapter.TvShowsAdapter
import com.example.movieapp.ui.viewmodel.TvShowsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(), ItemTvShowClickListener {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: TvShowsViewModel by viewModels()
    private lateinit var tvShowsAdapter: TvShowsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        bindViews()
        return binding.root
    }

    private fun bindViews() {
        tvShowsAdapter = TvShowsAdapter(this)
        viewModel.responseTvShows.observe(viewLifecycleOwner) { listTvShow ->
            tvShowsAdapter.tvShowsModel = listTvShow
        }
        binding.recyclerViewMovie.apply {
            adapter = tvShowsAdapter
            layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }
    }

    override fun onItemClick(model: TVShowsItem) {
        Toast.makeText(requireContext(), model.language, Toast.LENGTH_SHORT).show();
        val bundle = Bundle().apply {
            putString("IMAGE_BACK", model.image.medium)
            putString("RATE", model.rating.average.toString())
            putString("TIME", model.averageRuntime.toString())
            putString("DATE", model.ended)
            putString("LANGUAGE", model.language)
            putString("summary",model.summary)
        }
        findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundle)
    }
}