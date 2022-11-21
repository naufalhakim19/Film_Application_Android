package com.example.submission1_filmapplication.model

import androidx.lifecycle.ViewModel
import com.example.submission1_filmapplication.RepositoryMov
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.submission1_filmapplication.Asset

class MainMovieModel(private val repositoryMov: RepositoryMov) : ViewModel() {

    fun getMov():LiveData<Asset<PagedList<ModelMov>>> = repositoryMov.getDataMovie()

}