package com.example.submission1_filmapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.submission1_filmapplication.`object`.MovieInterface
import com.example.submission1_filmapplication.data.Api
import com.example.submission1_filmapplication.data.DataLocal
import com.example.submission1_filmapplication.data.ModelDataRepMov
import com.example.submission1_filmapplication.data.ModelDataRepTvshow
import com.example.submission1_filmapplication.model.*

class FakeRepository(
    private val remoteForData: RemoteForData, private val dataLocal: DataLocal,
    private val deputy: Deputy
) : MovieInterface {
    override fun getDataMovie(): LiveData<Asset<PagedList<ModelMov>>> {
        return object : NetworkBoundAsset<PagedList<ModelMov>, List<ModelDataRepMov>>(deputy) {
            override fun bring(data: PagedList<ModelMov>?): Boolean = data == null || data.isEmpty()

            override fun createCall(): LiveData<Api<List<ModelDataRepMov>>> =
                remoteForData.getDataMovie()


            override fun saveCallResult(data: List<ModelDataRepMov>) {
                val dataList = ArrayList<ModelMov>()

                for (i in data) {
                    val movie = ModelMov(
                        i.id,
                        i.title,
                        i.desc,
                        i.rating,
                        i.img,
                    )
                    dataList.add(movie)
                }
                dataLocal.insertMovie(dataList)
            }

            override fun loadfromDb(): LiveData<PagedList<ModelMov>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(dataLocal.getAllMovie(), config).build()
            }

        }.forLiveData()

    }

    override fun getDataDetailMovie(Id: String): LiveData<Asset<ModelMov>> {
        return object : NetworkBoundAsset<ModelMov, List<ModelDataRepMov>>(deputy) {
            override fun bring(data: ModelMov?): Boolean = data == null

            override fun createCall(): LiveData<Api<List<ModelDataRepMov>>> =
                remoteForData.getDataMovie()


            override fun saveCallResult(data: List<ModelDataRepMov>) {
                val dataList = ArrayList<ModelMov>()

                for (i in data) {
                    val movie = ModelMov(
                        i.id,
                        i.title,
                        i.desc,
                        i.rating,
                        i.img,
                        false
                    )
                    dataList.add(movie)
                }
                dataLocal.insertMovie(dataList)
            }

            override fun loadfromDb(): LiveData<ModelMov> = dataLocal.getMovieId(Id)

        }.forLiveData()
    }

    override fun getDataMovieFav(): LiveData<PagedList<ModelMov>> {
        val configure = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(dataLocal.getFavMov(), configure).build()
    }

    override fun setDataMovieFav(modelMov: ModelMov, boolean: Boolean) = deputy.diskIO().execute() {
        dataLocal.selectMovFav(modelMov, boolean)
    }

    override fun getDataTvshow(): LiveData<Asset<PagedList<ModelTvshow>>> {
        return object :
            NetworkBoundAsset<PagedList<ModelTvshow>, List<ModelDataRepTvshow>>(deputy) {
            override fun bring(data: PagedList<ModelTvshow>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<Api<List<ModelDataRepTvshow>>> =
                remoteForData.getDataTv()

            override fun saveCallResult(data: List<ModelDataRepTvshow>) {
                val dataList = ArrayList<ModelTvshow>()

                for (i in data) {
                    val show = ModelTvshow(
                        i.id,
                        i.title,
                        i.desc,
                        i.rating,
                        i.img,
                    )
                    dataList.add(show)
                }
                dataLocal.insertTvshow(dataList)
            }

            override fun loadfromDb(): LiveData<PagedList<ModelTvshow>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(dataLocal.getAllTvshow(), config).build()
            }

        }.forLiveData()
    }

    override fun getDataDetailTvshow(Id: String): LiveData<Asset<ModelTvshow>> {
        return object : NetworkBoundAsset<ModelTvshow, List<ModelDataRepTvshow>>(deputy) {
            override fun bring(data: ModelTvshow?): Boolean =
                data == null

            override fun createCall(): LiveData<Api<List<ModelDataRepTvshow>>> =
                remoteForData.getDataTv()

            override fun saveCallResult(data: List<ModelDataRepTvshow>) {
                lateinit var show: ModelTvshow
                for (i in data){
                    if (i.id == Id){
                        show = ModelTvshow(
                            i.id,
                            i.title,
                            i.desc,
                            i.rating,
                            i.img,
                            false
                        )
                    }
                    dataLocal.insertDetailTvshow(show)
                }
            }

            override fun loadfromDb(): LiveData<ModelTvshow> =
                dataLocal.getTvshowId(Id)

        }.forLiveData()
    }

    override fun getDataTvshowFav(): LiveData<PagedList<ModelTvshow>> {
        val configuring = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(dataLocal.getFavTv(), configuring).build()
    }

    override fun setDataTvshowFav(modelTvshow: ModelTvshow, boolean: Boolean) =
        deputy.diskIO().execute() {
            dataLocal.selectMovTv(modelTvshow, boolean)
        }



}