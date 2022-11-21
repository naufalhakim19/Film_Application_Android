package com.example.submission1_filmapplication.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.submission1_filmapplication.Asset
import com.example.submission1_filmapplication.RepositoryMov
import com.example.submission1_filmapplication.`object`.Dummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MainMovieModelTest {

    private lateinit var viewModeling: MainMovieModel

    @get:Rule
    var instantKiller = InstantTaskExecutorRule()

    @Mock
    private lateinit var repositoryMov: RepositoryMov

    @Mock
    private lateinit var dataMov: Observer<Asset<PagedList<ModelMov>>>

    @Mock
    private lateinit var filePagedList: PagedList<ModelMov>

    @Before
    fun trick(){
        viewModeling = MainMovieModel(repositoryMov)
    }

    @Test
    fun getMovie(){
        val dummyMovie = Asset.success(filePagedList)
        `when`(dummyMovie.data?.size).thenReturn(10)

        val film = MutableLiveData<Asset<PagedList<ModelMov>>>()
        film.value = dummyMovie

        `when`(repositoryMov.getDataMovie()).thenReturn(film)
        val modelFilm = viewModeling.getMov().value?.data
        verify(repositoryMov).getDataMovie()
        assertNotNull(film)
        assertEquals(10, modelFilm?.size)

        viewModeling.getMov().observeForever(dataMov)
        verify(dataMov).onChanged(dummyMovie)

    }
}