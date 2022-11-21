package com.example.submission1_filmapplication.`object`


import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.submission1_filmapplication.Asset
import com.example.submission1_filmapplication.model.ModelMov
import com.example.submission1_filmapplication.model.ModelTvshow


interface MovieInterface {

    fun getDataMovie(): LiveData<Asset<PagedList<ModelMov>>>

    fun getDataDetailMovie(Id: String): LiveData<Asset<ModelMov>>

    fun getDataMovieFav(): LiveData<PagedList<ModelMov>>

    fun setDataMovieFav(modelMov: ModelMov, boolean: Boolean)


    fun getDataTvshow(): LiveData<Asset<PagedList<ModelTvshow>>>

    fun getDataDetailTvshow(Id: String): LiveData<Asset<ModelTvshow>>

    fun getDataTvshowFav(): LiveData<PagedList<ModelTvshow>>

    fun setDataTvshowFav(modelTvshow: ModelTvshow, boolean: Boolean)


}