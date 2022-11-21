package com.example.submission1_filmapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission1_filmapplication.Status
import com.example.submission1_filmapplication.adapter.AdapterMovie
import com.example.submission1_filmapplication.databinding.FragmentMovieBinding
import com.example.submission1_filmapplication.model.MainMovieModel
import com.example.submission1_filmapplication.model.ViewModelFactory


class FragmentMovie : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MainMovieModel::class.java]

            //viewModel.getMov()
            val adapterMov = AdapterMovie()

            with(binding.fragmentMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = adapterMov
            }

            viewModel.getMov().observe(this, { movie ->
                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> binding.progressbar.visibility = View.GONE

                        Status.SUCCESS -> {
                            binding.progressbar.visibility = View.GONE
                            adapterMov.submitList(movie.data)
                            adapterMov.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            binding.progressbar.visibility = View.GONE
                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}