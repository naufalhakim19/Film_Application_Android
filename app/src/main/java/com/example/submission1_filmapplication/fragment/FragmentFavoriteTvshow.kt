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
import com.example.submission1_filmapplication.adapter.AdapterTvshowFavorite
import com.example.submission1_filmapplication.databinding.FragmentFavoriteMovieBinding
import com.example.submission1_filmapplication.databinding.FragmentFavoriteTvshowBinding
import com.example.submission1_filmapplication.model.FavoriteModel
import com.example.submission1_filmapplication.model.ViewModelFactory

class FragmentFavoriteTvshow : Fragment() {
    private lateinit var binding: FragmentFavoriteTvshowBinding
    private lateinit var favoriteModel: FavoriteModel
    private lateinit var adapterTvshowFavorite: AdapterTvshowFavorite

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteTvshowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemData.attachToRecyclerView(binding?.rvTvshowFav)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            favoriteModel = ViewModelProvider(this, factory)[FavoriteModel::class.java]

            adapterTvshowFavorite = AdapterTvshowFavorite()

            favoriteModel.getDataFavTv().observe(this, { favorite ->
                binding.progressbar.visibility = View.GONE
                adapterTvshowFavorite.submitList(favorite)
            })
            with(binding.rvTvshowFav) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = adapterTvshowFavorite
            }
        }
    }

    private val itemData = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int = makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipe = viewHolder.adapterPosition
                val modTv = adapterTvshowFavorite.getDataTvshow(swipe)
                modTv?.let { favoriteModel.setdataFavTv(it) }


            }
        }

    })

}