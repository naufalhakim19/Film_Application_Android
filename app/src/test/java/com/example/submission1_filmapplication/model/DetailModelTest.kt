package com.example.submission1_filmapplication.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submission1_filmapplication.Asset
import com.example.submission1_filmapplication.RepositoryMov
import com.example.submission1_filmapplication.`object`.Dummy
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailModelTest {

    private lateinit var detailModel: DetailModel
    private lateinit var detailModelTv: DetailModel
    private val movie = Dummy.dataMov()[0]
    private val tvshow = Dummy.dataTvshow()[0]
    private val movId = movie.id
    private val tvShowId = tvshow.id

    @get:Rule
    var kill = InstantTaskExecutorRule()

    @Mock
    lateinit var repositoryMov: RepositoryMov

    @Mock
    private lateinit var dataMov: Observer<Asset<ModelMov>>

    @Mock
    private lateinit var dataTv: Observer<Asset<ModelTvshow>>

    @Before
    fun trick() {
        detailModel = DetailModel(repositoryMov)
        detailModel.setDataMovie(movId)
    }

    @Before
    fun lies() {
        detailModelTv = DetailModel(repositoryMov)
        detailModelTv.setTv(tvShowId)
    }

    @Test
    fun takeMovie() {
        val dummyMovie = Asset.success(movie)
        val detailMovie = MutableLiveData<Asset<ModelMov>>()
        detailMovie.value = dummyMovie

        `when`(repositoryMov.getDataDetailMovie(movId)).thenReturn(detailMovie)
        detailModel.getDataDetailMovie.observeForever(dataMov)
        verify(dataMov).onChanged(dummyMovie)
    }


    @Test
    fun layFavoriteMovie() {
        val dummyMov = Asset.success(movie.copy(fav = false))
        val detailMov = MutableLiveData<Asset<ModelMov>>()
        detailMov.value = dummyMov
        `when`(repositoryMov.getDataDetailMovie(movId)).thenReturn(detailMov)
        detailModel.getDataDetailMovie = repositoryMov.getDataDetailMovie(movId)
        detailModel.favMov()
        verify(repositoryMov)
            .setDataMovieFav(detailMov.value?.data?.copy(fav = false) as ModelMov, true)
        verifyNoMoreInteractions(dataMov)
    }

    @Test
    fun destroyFavoriteMovie() {
        val dummyMov = Asset.success(movie.copy(fav = true))
        val detailMov = MutableLiveData<Asset<ModelMov>>()
        detailMov.value = dummyMov
        `when`(repositoryMov.getDataDetailMovie(movId)).thenReturn(detailMov)

        detailModel.getDataDetailMovie = repositoryMov.getDataDetailMovie(movId)
        detailModel.favMov()
        verify(repositoryMov)
            .setDataMovieFav(detailMov.value?.data?.copy(fav = true) as ModelMov, false)
        verifyNoMoreInteractions(dataMov)
    }

    //buat tv shownyaa

    @Test
    fun takeShow() {
        val dummyShow = Asset.success(tvshow)
        val detailShow = MutableLiveData<Asset<ModelTvshow>>()
        detailShow.value = dummyShow

        `when`(repositoryMov.getDataDetailTvshow(tvShowId)).thenReturn(detailShow)
        detailModelTv.getDataDetailTvshow.observeForever(dataTv)
        verify(dataTv).onChanged(dummyShow)
    }


    @Test
    fun layFavoriteShow() {
        val dummyShow = Asset.success(tvshow.copy(fav = false))
        val detailShow = MutableLiveData<Asset<ModelTvshow>>()
        detailShow.value = dummyShow
        Mockito.`when`(repositoryMov.getDataDetailTvshow(tvShowId)).thenReturn(detailShow)
        detailModelTv.getDataDetailTvshow = repositoryMov.getDataDetailTvshow(tvShowId)
        detailModelTv.favShow()
        verify(repositoryMov)
            .setDataTvshowFav(detailShow.value?.data?.copy(fav = false) as ModelTvshow, true)
        verifyNoMoreInteractions(dataTv)
    }

    @Test
    fun destroyFavoriteShow() {
        val dummyShow = Asset.success(tvshow.copy(fav = true))
        val detailShow = MutableLiveData<Asset<ModelTvshow>>()
        detailShow.value = dummyShow
        `when`(repositoryMov.getDataDetailTvshow(tvShowId)).thenReturn(detailShow)

        detailModelTv.getDataDetailTvshow = repositoryMov.getDataDetailTvshow(tvShowId)
        detailModelTv.favShow()
        verify(repositoryMov)
            .setDataTvshowFav(detailShow.value?.data?.copy(fav = true) as ModelTvshow, false)
        verifyNoMoreInteractions(dataTv)
    }

}