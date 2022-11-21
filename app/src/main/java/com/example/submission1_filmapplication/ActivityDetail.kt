package com.example.submission1_filmapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.submission1_filmapplication.databinding.ActivityDetailBinding
import com.example.submission1_filmapplication.model.*

class ActivityDetail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailModel: DetailModel

    private var menu: Menu? = null

    companion object {
        const val MOVIE_ID = "movie_id"
        const val TVSHOW_ID = "tvshow_id"
        const val REQUEST = 1
    }

    enum class REQUEST(val req: Int) {
        REQUEST_MOV(1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail Film"

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        detailModel = ViewModelProvider(this, factory)[DetailModel::class.java]

        getAllData()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        this.menu = menu

        if (ActivityDetail.REQUEST.REQUEST_MOV.req == intent.extras?.getInt("request")) {
            detailModel.getDataDetailMovie.observe(this, { detailMov ->
                if (detailMov != null) {
                    when (detailMov.status) {
                        Status.LOADING -> binding.progressbar.visibility = View.VISIBLE

                        Status.SUCCESS -> if (detailMov.data != null) {
                            binding.progressbar.visibility = View.GONE
                            val state = detailMov.data.fav
                            setFavorite(state)
                        }
                        Status.ERROR -> {
                            binding.progressbar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        } else {
            detailModel.getDataDetailTvshow.observe(this, { detailTV ->
                if (detailTV != null) {
                    when (detailTV.status) {
                        Status.LOADING -> binding.progressbar.visibility = View.VISIBLE

                        Status.SUCCESS -> if (detailTV.data != null) {
                            binding.progressbar.visibility = View.GONE
                            val state = detailTV.data.fav
                            setFavorite(state)
                        }
                        Status.ERROR -> {
                            binding.progressbar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.fav_border) {
            return if (ActivityDetail.REQUEST.REQUEST_MOV.req == intent.extras?.getInt("request")) {
                detailModel.favMov()
                true
            } else {
                detailModel.favShow()
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavorite(state: Boolean) {

        if (menu == null) return
        val obj = menu?.findItem(R.id.fav_border)
        if (state) {
            obj?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
        } else {
            obj?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
        }

    }


    private fun getAllData() {
        if (REQUEST == intent.extras?.getInt("request")) {
            val extraMov = intent.extras
            if (extraMov != null) {
                val movId = extraMov.getString(MOVIE_ID)

                if (movId != null) {
                    binding.progressbar.visibility = View.GONE
                    detailModel.setDataMovie(movId)

                    detailModel.getDataDetailMovie.observe(this, { movie ->
                        if (movie != null) {
                            when (movie.status) {
                                Status.LOADING -> binding.progressbar.visibility = View.GONE

                                Status.SUCCESS -> if (movie.data != null) {
                                    binding.progressbar.visibility = View.GONE
                                    listMov(movie.data)
                                }

                                Status.ERROR -> {
                                    binding.progressbar.visibility = View.GONE
                                    Toast.makeText(applicationContext, "Error ", Toast.LENGTH_SHORT)
                                        .show()

                                }
                            }
                        }
                    })
                }
            }
        } else {
            val extraTv = intent.extras
            if (extraTv != null) {
                val tvshowId = extraTv.getString(TVSHOW_ID)
                if (tvshowId != null) {
                    binding.progressbar.visibility = View.GONE
                    detailModel.setTv(tvshowId)

                    detailModel.getDataDetailTvshow.observe(this, { tvshow ->
                        if (tvshow != null) {
                            when (tvshow.status) {
                                Status.LOADING -> binding.progressbar.visibility = View.GONE

                                Status.SUCCESS -> if (tvshow.data != null) {
                                    binding.progressbar.visibility = View.GONE

                                    listTvshow(tvshow.data)
                                }

                                Status.ERROR -> {
                                    binding.progressbar.visibility = View.GONE
                                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                        }
                    })
                }
            }
        }
    }

    private fun listMov(modelMov: ModelMov) {
        binding.tvDetailTitle.text = modelMov.title
        binding.tvDetailDesc.text = getString(R.string.description_s, modelMov.desc)
        binding.tvDetailRating.text = getString(R.string.s_5, modelMov.rating)
        Glide.with(this)
            .load(modelMov.img)
            .into(binding.ivDetailImg)
        title = "${modelMov.title}"
    }

    private fun listTvshow(modelTvshow: ModelTvshow) {
        binding.tvDetailTitle.text = modelTvshow.title
        binding.tvDetailDesc.text = getString(R.string.description_s, modelTvshow.desc)
        binding.tvDetailRating.text = getString(R.string.s_5, modelTvshow.rating)
        Glide.with(this)
            .load(modelTvshow.img)
            .into(binding.ivDetailImg)
        title = "${modelTvshow.title}"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}