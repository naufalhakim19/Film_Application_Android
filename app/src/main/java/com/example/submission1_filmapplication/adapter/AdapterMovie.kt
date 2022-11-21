package com.example.submission1_filmapplication.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submission1_filmapplication.ActivityDetail
import com.example.submission1_filmapplication.R
import com.example.submission1_filmapplication.databinding.ListItemBinding
import com.example.submission1_filmapplication.model.Model
import com.example.submission1_filmapplication.model.ModelMov
import kotlinx.android.synthetic.main.list_item.view.*

class AdapterMovie : PagedListAdapter<ModelMov, AdapterMovie.ViewHolder>(FALLBACK) {

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
        @SuppressLint("StringFormatInvalid")
        fun bind(modelMov: ModelMov) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(modelMov.img)
                    .apply(RequestOptions().override(100, 100))
                    .into(iv_img)
                binding.tvTitle.text = modelMov.title
                binding.tvRating.text = itemView.context.getString(R.string.s_5, modelMov.rating)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, ActivityDetail::class.java)
                    intent.putExtra(ActivityDetail.MOVIE_ID, modelMov.id)
                    intent.putExtra("request", 1)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val mov = ListItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(mov)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

}
