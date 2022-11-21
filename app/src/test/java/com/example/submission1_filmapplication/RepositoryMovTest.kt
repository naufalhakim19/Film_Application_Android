package com.example.submission1_filmapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.submission1_filmapplication.`object`.Dummy
import com.example.submission1_filmapplication.`object`.LiveData
import com.example.submission1_filmapplication.data.DataLocal
import com.example.submission1_filmapplication.model.ModelMov
import com.example.submission1_filmapplication.model.ModelTvshow
import com.nhaarman.mockitokotlin2.*
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito

class RepositoryMovTest {

    @get:Rule
    var killer = InstantTaskExecutorRule()

    private val remoteNya = Mockito.mock(RemoteForData::class.java)
    private val localData = Mockito.mock(DataLocal::class.java)
    private val appKiller = Mockito.mock(Deputy::class.java)
    private val repository1 = FakeRepository(remoteNya,localData, appKiller)

    private val testKillers = Deputy(TestKiller(), TestKiller(), TestKiller())

    private val movieRep = Dummy.remoteDataMov()
    private val movId = movieRep[0].id

    private val showRep = Dummy.remoteDataTvshow()
    private val showId = showRep[0].id

    @Test
    fun takeMovie() {
        val dataFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ModelMov>
        Mockito.`when`(localData.getAllMovie()).thenReturn(dataFactory)
        repository1.getDataMovie()

        val movieEnties = Asset.success(FilePage.fauxFilePAge(Dummy.remoteDataTvshow()))

        verify(localData).getAllMovie()
        assertNotNull(movieEnties.data)
        assertEquals(movieRep.size.toLong(), movieEnties.data?.size?.toLong())
    }

    @Test
    fun takeDetailMovie() {
        val dummyEnties = MutableLiveData<ModelMov>()
        dummyEnties.value = Dummy.dataMov()[0]
        Mockito.`when`(localData.getMovieId(movId)).thenReturn(dummyEnties)

        val detailMovie = LiveDataTesting.getValue(repository1.getDataDetailMovie(movId))

        verify(localData).getMovieId(movId)
        assertNotNull(detailMovie)
        assertEquals(movieRep[0].title, detailMovie.data?.title)
    }

    @Test
    fun takeFavoriteMovie() {
        val dataFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ModelMov>
        Mockito.`when`(localData.getFavMov()).thenReturn(dataFactory)
        repository1.getDataMovieFav()

        val movieEnties = Asset.success(FilePage.fauxFilePAge(Dummy.remoteDataMov()))
        verify(localData).getFavMov()
        assertNotNull(movieEnties)
        assertEquals(movieRep.size.toLong(), movieEnties.data?.size?.toLong())
    }

    @Test
    fun setFavoriteMovie() {
        val dumbMovie = Dummy.dataMov()[0]
        val theState = !dumbMovie.fav

        Mockito.`when`(appKiller.diskIO()).thenReturn(testKillers.diskIO())
        doNothing().`when`(localData).selectMovFav(dumbMovie, theState)

        repository1.setDataMovieFav(dumbMovie, theState)
        verify(localData, times(1)).selectMovFav(dumbMovie, theState)
    }

    @Test
    fun deleteFavoriteMov() {
        val dummyMovie = Dummy.dataMov()[0]
        val theState = dummyMovie.fav

        Mockito.`when`(appKiller.diskIO()).thenReturn(testKillers.diskIO())
        doNothing().`when`(localData).selectMovFav(dummyMovie, theState)

        repository1.setDataMovieFav(dummyMovie, theState)
        verify(localData, times(1)).selectMovFav(dummyMovie, theState)
    }

    @Test
    fun takeShow() {
        val dataFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ModelTvshow>
        Mockito.`when`(localData.getAllTvshow()).thenReturn(dataFactory)
        repository1.getDataTvshow()

        val showEnties = Asset.success(FilePage.fauxFilePAge(Dummy.remoteDataTvshow()))

        verify(localData).getAllTvshow()
        assertNotNull(showEnties.data)
        assertEquals(showRep.size.toLong(), showEnties.data?.size?.toLong())
    }

    @Test
    fun takeDetailShow() {
        val dummyEnties = MutableLiveData<ModelTvshow>()
        dummyEnties.value = Dummy.dataTvshow()[0]
        Mockito.`when`(localData.getTvshowId(showId)).thenReturn(dummyEnties)

        val detailShow = LiveDataTesting.getValue(repository1.getDataDetailTvshow(showId))

        verify(localData).getTvshowId(showId)
        assertNotNull(detailShow)
        assertEquals(showRep[0].title, detailShow.data?.title)
    }

    @Test
    fun takeFavoriteShow() {
        val dataFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ModelTvshow>
        Mockito.`when`(localData.getFavTv()).thenReturn(dataFactory)
        repository1.getDataTvshowFav()

        val showEnties = Asset.success(FilePage.fauxFilePAge(Dummy.remoteDataTvshow()))
        verify(localData).getFavTv()
        assertNotNull(showEnties)
        assertEquals(showRep.size.toLong(), showEnties.data?.size?.toLong())
    }

    @Test
    fun setFavoriteShow() {
        val dumbShow = Dummy.dataTvshow()[0]
        val theState = !dumbShow.fav

        Mockito.`when`(appKiller.diskIO()).thenReturn(testKillers.diskIO())
        doNothing().`when`(localData).selectMovTv(dumbShow, theState)

        repository1.setDataTvshowFav(dumbShow, theState)
        verify(localData, times(1)).selectMovTv(dumbShow, theState)
    }

    @Test
    fun deleteFavoriteShow() {
        val dummyShow = Dummy.dataTvshow()[0]
        val theState = dummyShow.fav

        Mockito.`when`(appKiller.diskIO()).thenReturn(testKillers.diskIO())
        doNothing().`when`(localData).selectMovTv(dummyShow, theState)

        repository1.setDataTvshowFav(dummyShow, theState)
        verify(localData, times(1)).selectMovTv(dummyShow, theState)
    }
}