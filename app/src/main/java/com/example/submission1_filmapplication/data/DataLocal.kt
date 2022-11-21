package com.example.submission1_filmapplication.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.submission1_filmapplication.`object`.MovTvDao
import com.example.submission1_filmapplication.model.ModelMov
import com.example.submission1_filmapplication.model.ModelTvshow

class DataLocal private constructor(private val movTvDao: MovTvDao) {

    companion object {
        private var instace: DataLocal? = null

        fun getInstance(movTvDao: MovTvDao): DataLocal = instace ?: DataLocal(movTvDao)
    }

    fun getAllMovie(): DataSource.Factory<Int, ModelMov> = movTvDao.getDataMovie()

    fun getMovieId(id: String): LiveData<ModelMov> = movTvDao.getDataMovieId(id)

    fun insertMovie(movie: List<ModelMov>) = movTvDao.putDataMovie(movie)

    fun insertDetailMovie(modelMov: ModelMov) = movTvDao.getDataMovieFav()

    fun getFavMov(): DataSource.Factory<Int, ModelMov> = movTvDao.getDataMovieFav()

    fun selectMovFav(modelMov: ModelMov, boolean: Boolean) {
        modelMov.fav = boolean
        movTvDao.updateDataMovie(modelMov)
    }

    fun getAllTvshow(): DataSource.Factory<Int, ModelTvshow> = movTvDao.getDataTvshow()

    fun getTvshowId(id: String): LiveData<ModelTvshow> = movTvDao.getDataTvshowId(id)

    fun insertTvshow(tvshow: List<ModelTvshow>) = movTvDao.putDataTvshow(tvshow)

    fun insertDetailTvshow(modelTvshow: ModelTvshow) = movTvDao.getDataTvshowFav()

    fun getFavTv(): DataSource.Factory<Int, ModelTvshow> = movTvDao.getDataTvshowFav()

    fun selectMovTv(modelTvshow: ModelTvshow, boolean: Boolean) {
        modelTvshow.fav = boolean
        movTvDao.updateDataTvshow(modelTvshow)
    }


}