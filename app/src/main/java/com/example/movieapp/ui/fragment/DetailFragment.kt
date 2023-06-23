package com.example.movieapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentDetailBinding.inflate(inflater,container,false)
        bindViews()
        return binding.root
    }

    private fun bindViews() {
        val args = requireArguments()
        val imageBackground = args.getString("IMAGE_BACK")
        Picasso.get().load(imageBackground).into(binding.imageBackground)
        Picasso.get().load(imageBackground).into(binding.imageMovie)
        binding.rate.text=args.getString("RATE")
        binding.time.text=args.getString("TIME")
        binding.language.text=args.getString("LANGUAGE")
        binding.date.text=args.getString("DATE")
        binding.summary.text=args.getString("summary")
    }
}