package com.example.submission1_filmapplication.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.submission1_filmapplication.Asset
import com.example.submission1_filmapplication.RepositoryMov

class DetailModel(private val repositoryMov: RepositoryMov) : ViewModel() {

    val id = MutableLiveData<String>()

    fun setDataMovie(movId: String) {
        this.id.value = movId
    }

    var getDataDetailMovie: LiveData<Asset<ModelMov>> = Transformations.switchMap(id) { movieId ->
        repositoryMov.getDataDetailMovie(movieId)
    }

    fun favMov() {
        val movAsset = getDataDetailMovie.value
        if (movAsset != null) {
            val movEntities = movAsset.data

            if (movEntities != null) {
                val new = !movEntities.fav
                repositoryMov.setDataMovieFav(movEntities, new)
            }
        }
    }

    fun setTv(tvId: String) {
        this.id.value = tvId
    }

    var getDataDetailTvshow: LiveData<Asset<ModelTvshow>> =
        Transformations.switchMap(id) { tvshow ->
            repositoryMov.getDataDetailTvshow(tvshow)
        }

    fun favShow() {
        val showAsset = getDataDetailTvshow.value
        if (showAsset != null) {
            val showEntities = showAsset.data

            if (showEntities != null) {
                val new = !showEntities.fav
                repositoryMov.setDataTvshowFav(showEntities, new)
            }
        }
    }
}