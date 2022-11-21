package com.example.submission1_filmapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submission1_filmapplication.R
import com.example.submission1_filmapplication.adapter.AdapterMovieFavorite
import com.example.submission1_filmapplication.databinding.FragmentFavoriteBinding
import com.example.submission1_filmapplication.databinding.FragmentFavoriteMovieBinding
import com.example.submission1_filmapplication.model.FavoriteModel
import com.example.submission1_filmapplication.model.ModelMov
import com.example.submission1_filmapplication.model.ViewModelFactory
import com.example.submission1_filmapplication.model.ViewModelFactory.Companion.getInstance
import com.google.android.material.snackbar.Snackbar

class FragmentFavoriteMovie : Fragment() {

    private lateinit var binding: FragmentFavoriteMovieBinding
    private lateinit var adapterMovieFavorite: AdapterMovieFavorite
    private lateinit var viewModelMov: FavoriteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemData.attachToRecyclerView(binding?.rvMovieFav)

        if (activity != null) {
            val factory = getInstance(requireContext())
            viewModelMov = ViewModelProvider(this, factory)[FavoriteModel::class.java]

            adapterMovieFavorite = AdapterMovieFavorite()

            viewModelMov.getDataFavMov().observe(this, { favorite ->
                binding.progressbar.visibility = View.GONE
                adapterMovieFavorite.submitList(favorite)
            })

            with(binding.rvMovieFav) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = adapterMovieFavorite
            }

        }
    }

    private val itemData = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)


        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipe = viewHolder.adapterPosition
                val modMov = adapterMovieFavorite.getDataMovie(swipe)
                modMov?.let { viewModelMov.setDataFavMov(it) }

            }
        }

    })

}