package com.example.submission1_filmapplication.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submission1_filmapplication.ActivityDetail
import com.example.submission1_filmapplication.databinding.ListItemBinding
import com.example.submission1_filmapplication.model.ModelMov


class AdapterMovieFavorite : PagedListAdapter<ModelMov, AdapterMovieFavorite.ViewHolder>(FALLBACK) {

    companion object {
        private val FALLBACK = object : DiffUtil.ItemCallback<ModelMov>() {
            override fun areItemsTheSame(oldItem: ModelMov, newItem: ModelMov): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ModelMov, newItem: ModelMov): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(modelMov: ModelMov) {
            with(binding) {
                tvTitle.text = modelMov.title

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, ActivityDetail::class.java)
                    intent.putExtra(ActivityDetail.MOVIE_ID, modelMov.id)
                    intent.putExtra("request", 1)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(modelMov.img)
                    .into(ivImg)
            }
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val movieList =
            ListItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(movieList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    fun getDataMovie(position: Int): ModelMov? = getItem(position)
}