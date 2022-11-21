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
import com.example.submission1_filmapplication.model.ModelTvshow

class AdapterTvshowFavorite :
    PagedListAdapter<ModelTvshow, AdapterTvshowFavorite.ViewHolder>(FALLBACK) {

    companion object {
        private val FALLBACK = object : DiffUtil.ItemCallback<ModelTvshow>() {
            override fun areItemsTheSame(oldItem: ModelTvshow, newItem: ModelTvshow): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ModelTvshow, newItem: ModelTvshow): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(modelTvshow: ModelTvshow) {
            binding.tvTitle.text = modelTvshow.title

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, ActivityDetail::class.java)
                intent.putExtra(ActivityDetail.TVSHOW_ID, modelTvshow.id)
                itemView.context.startActivity(intent)
            }

            Glide.with(itemView.context)
                .load(modelTvshow.img)
                .into(binding.ivImg)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val tvshowList =
            ListItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(tvshowList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvshow = getItem(position)
        if (tvshow != null) {
            holder.bind(tvshow)
        }
    }

    fun getDataTvshow(position: Int): ModelTvshow? = getItem(position)

}