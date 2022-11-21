package com.example.submission1_filmapplication.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.submission1_filmapplication.RepositoryMov
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteModelTest {
    private lateinit var favoriteModel: FavoriteModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repositoryMov: RepositoryMov

    @Mock
    private lateinit var dataMov: Observer<PagedList<ModelMov>>

    @Mock
    private lateinit var filePageMov: PagedList<ModelMov>

    @Mock
    private lateinit var dataShow: Observer<PagedList<ModelTvshow>>

    @Mock
    private lateinit var filePageShow: PagedList<ModelTvshow>

    @Before
    fun trick() {
        favoriteModel = FavoriteModel(repositoryMov)
    }

    @Test
    fun takeFavoriteMov() {
        val dummyMovie = filePageMov
        Mockito.`when`(dummyMovie.size).thenReturn(10)
        val movie = MutableLiveData<PagedList<ModelMov>>()
        movie.value = dummyMovie

        Mockito.`when`(repositoryMov.getDataMovieFav()).thenReturn(movie)
        val movieEnties = favoriteModel.getDataFavMov().value
        verify(repositoryMov).getDataMovieFav()
        assertNotNull(movieEnties)
        assertEquals(10, movieEnties?.size)

        favoriteModel.getDataFavMov().observeForever(dataMov)
        verify(dataMov).onChanged(dummyMovie)
    }

    @Test
    fun takeFavoriteShow() {
        val dummyShow = filePageShow
        Mockito.`when`(dummyShow.size).thenReturn(10)
        val show = MutableLiveData<PagedList<ModelTvshow>>()
        show.value = dummyShow

        Mockito.`when`(repositoryMov.getDataTvshowFav()).thenReturn(show)
        val showEntitas = favoriteModel.getDataFavTv().value
        verify(repositoryMov).getDataTvshowFav()
        assertNotNull(showEntitas)
        assertEquals(10, showEntitas?.size)

        favoriteModel.getDataFavTv().observeForever(dataShow)
        verify(dataShow).onChanged(dummyShow)
    }
}