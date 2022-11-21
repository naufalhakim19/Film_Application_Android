package com.example.submission1_filmapplication.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submission1_filmapplication.RepositoryMov

class FavoriteModel(private val repositoryMov: RepositoryMov) : ViewModel() {

    fun getDataFavMov(): LiveData<PagedList<ModelMov>> = repositoryMov.getDataMovieFav()

    fun setDataFavMov(modelMov: ModelMov) {
        val new = !modelMov.fav
        repositoryMov.setDataMovieFav(modelMov, new)
    }

    fun getDataFavTv(): LiveData<PagedList<ModelTvshow>> = repositoryMov.getDataTvshowFav()

    fun setdataFavTv(modelTvshow: ModelTvshow) {
        val new = !modelTvshow.fav
        repositoryMov.setDataTvshowFav(modelTvshow, new)
    }
}