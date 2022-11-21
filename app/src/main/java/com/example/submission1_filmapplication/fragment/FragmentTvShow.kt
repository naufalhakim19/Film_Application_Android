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
import com.example.submission1_filmapplication.adapter.AdapterTvShow
import com.example.submission1_filmapplication.databinding.FragmentTvShowBinding
import com.example.submission1_filmapplication.model.*
import com.example.submission1_filmapplication.model.ViewModelFactory.Companion.getInstance


class FragmentTvShow : Fragment() {
    private lateinit var binding: FragmentTvShowBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MainTvModel::class.java]

            viewModel.getTv()

            val tvAdapter = AdapterTvShow()
            with(binding.fragmentTvshow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvAdapter
            }

            viewModel.getTv().observe(this, { tvshow ->
                if (tvshow != null) {
                    when (tvshow.status) {
                        Status.LOADING -> binding.progressbar.visibility = View.GONE

                        Status.SUCCESS -> {
                            binding.progressbar.visibility = View.GONE
                            tvAdapter.submitList(tvshow.data)
                            tvAdapter.notifyDataSetChanged()
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
        binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}