package com.example.submission1_filmapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.submission1_filmapplication.PagerFavorite
import com.example.submission1_filmapplication.R
import com.example.submission1_filmapplication.databinding.FragmentFavoriteBinding

class FragmentFavorite : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val setting = PagerFavorite(requireContext(), childFragmentManager)

        binding.vpFav.adapter = setting
        binding.tabLayoutFav.setupWithViewPager(binding.vpFav)
    }
}