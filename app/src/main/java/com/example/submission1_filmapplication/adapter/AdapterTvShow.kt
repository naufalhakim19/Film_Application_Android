package com.example.submission1_filmapplication.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submission1_filmapplication.ActivityDetail
import com.example.submission1_filmapplication.R
import com.example.submission1_filmapplication.databinding.ListItemBinding
import com.example.submission1_filmapplication.model.Model
import com.example.submission1_filmapplication.model.ModelTvshow
import kotlinx.android.synthetic.main.list_item.view.*

class AdapterTvShow : PagedListAdapter<ModelTvshow, AdapterTvShow.ViewHolder>(FALLBACK) {
    private var dataList = ArrayList<Model>()

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
        @SuppressLint("StringFormatInvalid")
        fun bind(modelTvshow: ModelTvshow) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(modelTvshow.img)
                    .apply(RequestOptions().override(100, 100))
                    .into(iv_img)
                binding.tvTitle.text = modelTvshow.title
                binding.tvRating.text = itemView.context.getString(R.string.s_5, modelTvshow.rating)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, ActivityDetail::class.java)
                    intent.putExtra(ActivityDetail.TVSHOW_ID, modelTvshow.id)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val show =
            ListItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(show)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvshow = getItem(position)
        if (tvshow != null) {
            holder.bind(tvshow)
        }
    }

}