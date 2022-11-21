package com.example.submission1_filmapplication.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submission1_filmapplication.Asset
import com.example.submission1_filmapplication.RepositoryMov

class MainTvModel(private val repositoryMov: RepositoryMov) : ViewModel() {
    fun getTv(): LiveData<Asset<PagedList<ModelTvshow>>> = repositoryMov.getDataTvshow()
}