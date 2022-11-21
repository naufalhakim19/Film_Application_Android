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
class MainTvModelTest {

    private lateinit var mainTvModel: MainTvModel

    @get:Rule
    var instantKiller = InstantTaskExecutorRule()

    @Mock
    private lateinit var repositoryMov: RepositoryMov

    @Mock
    private lateinit var dataTv: Observer<Asset<PagedList<ModelTvshow>>>

    @Mock
    private lateinit var filePagedList: PagedList<ModelTvshow>

    @Before
    fun trick(){
        mainTvModel = MainTvModel(repositoryMov)
    }

    @Test
    fun getShow(){
        val dummyShow = Asset.success(filePagedList)
        `when`(dummyShow.data?.size).thenReturn(10)

        val Tv = MutableLiveData<Asset<PagedList<ModelTvshow>>>()
        Tv.value = dummyShow

        `when`(repositoryMov.getDataTvshow()).thenReturn(Tv)
        val modelAcaraTv = mainTvModel.getTv().value?.data
        verify(repositoryMov).getDataTvshow()
        assertNotNull(Tv)
        assertEquals(10, modelAcaraTv?.size)

        mainTvModel.getTv().observeForever(dataTv)
        verify(dataTv).onChanged(dummyShow)

    }
}