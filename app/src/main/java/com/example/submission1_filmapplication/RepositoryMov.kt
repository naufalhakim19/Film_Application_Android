package com.example.submission1_filmapplication

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.submission1_filmapplication.`object`.MovieInterface
import com.example.submission1_filmapplication.data.Api
import com.example.submission1_filmapplication.data.DataLocal
import com.example.submission1_filmapplication.data.ModelDataRepMov
import com.example.submission1_filmapplication.data.ModelDataRepTvshow
import com.example.submission1_filmapplication.model.*

class
RepositoryMov private constructor(
    private val remoteForData: RemoteForData, private val dataLocal: DataLocal,
    private val deputy: Deputy
) :
    MovieInterface {


    companion object {
        @Volatile
        private var instance: RepositoryMov? = null

        fun getInstance(
            remoteForData: RemoteForData,
            dataLocal: DataLocal,
            deputy: Deputy
        ): RepositoryMov =
            instance ?: synchronized(this) {
                instance ?: RepositoryMov(remoteForData, dataLocal, deputy).apply {
                    instance = this
                }
            }
    }

    override fun getDataMovie(): LiveData<Asset<PagedList<ModelMov>>> {
        return object : NetworkBoundAsset<PagedList<ModelMov>, List<ModelDataRepMov>>(deputy) {
            override fun loadfromDb(): LiveData<PagedList<ModelMov>> {
                val setting = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(dataLocal.getAllMovie(), setting).build()
            }
    
            override fun bring(data: PagedList<ModelMov>?): Boolean = data == null || data.isEmpty()

            override fun createCall(): LiveData<Api<List<ModelDataRepMov>>> =
                remoteForData.getDataMovie()

            override fun saveCallResult(data: List<ModelDataRepMov>) {
                val datalist = ArrayList<ModelMov>()

                for (i in data) {
                    val movie = ModelMov(
                        i.id,
                        i.title,
                        i.desc,
                        i.rating,
                        i.img
                    )
                    datalist.add(movie)
                }
                dataLocal.insertMovie(datalist)
            }
        }.forLiveData()
    }

    override fun getDataDetailMovie(Id: String): LiveData<Asset<ModelMov>> {
        return object : NetworkBoundAsset<ModelMov, List<ModelDataRepMov>>(deputy) {
            override fun loadfromDb(): LiveData<ModelMov> = dataLocal.getMovieId(Id)

            override fun bring(data: ModelMov?): Boolean =
                data == null || data.id.isNotEmpty()


            override fun createCall(): LiveData<Api<List<ModelDataRepMov>>> =
                remoteForData.getDataMovie()

            override fun saveCallResult(data: List<ModelDataRepMov>) {
                lateinit var modelMov: ModelMov
                for (i in data) {
                    if (i.id == Id) {
                        modelMov = ModelMov(
                            i.id,
                            i.title,
                            i.desc,
                            i.rating,
                            i.img,
                            false
                        )
                        dataLocal.insertDetailMovie(modelMov)
                    }
                }
            }

        }.forLiveData()
    }

    override fun getDataMovieFav(): LiveData<PagedList<ModelMov>> {
        val setting = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(5)
            .build()

        return LivePagedListBuilder(dataLocal.getFavMov(), setting).build()
    }

    override fun setDataMovieFav(modelMov: ModelMov, boolean: Boolean) {
        deputy.diskIO().execute() {
            dataLocal.selectMovFav(modelMov, boolean)
        }
    }

    override fun getDataTvshow(): LiveData<Asset<PagedList<ModelTvshow>>> {

        return object :
            NetworkBoundAsset<PagedList<ModelTvshow>, List<ModelDataRepTvshow>>(deputy) {
            override fun loadfromDb(): LiveData<PagedList<ModelTvshow>> {
                val setting = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(dataLocal.getAllTvshow(), setting).build()
            }

            override fun bring(data: PagedList<ModelTvshow>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<Api<List<ModelDataRepTvshow>>> =
                remoteForData.getDataTv()

            override fun saveCallResult(data: List<ModelDataRepTvshow>) {
                val dataList = ArrayList<ModelTvshow>()

                for (i in data) {
                    val tvshow = ModelTvshow(
                        i.id,
                        i.title,
                        i.desc,
                        i.rating,
                        i.img,
                        false
                    )
                    dataList.add(tvshow)
                }
                dataLocal.insertTvshow(dataList)
            }

        }.forLiveData()
    }

    override fun getDataDetailTvshow(Id: String): LiveData<Asset<ModelTvshow>> {
        return object : NetworkBoundAsset<ModelTvshow, List<ModelDataRepTvshow>>(deputy) {
            override fun loadfromDb(): LiveData<ModelTvshow> {
                return dataLocal.getTvshowId(Id)
            }

            override fun bring(data: ModelTvshow?): Boolean = data == null

            override fun createCall(): LiveData<Api<List<ModelDataRepTvshow>>> =
                remoteForData.getDataTv()

            override fun saveCallResult(data: List<ModelDataRepTvshow>) {
                lateinit var modelTvshow: ModelTvshow
                for (i in data) {
                    if (i.id == Id) {
                        modelTvshow = ModelTvshow(
                            i.id,
                            i.title,
                            i.desc,
                            i.rating,
                            i.img,
                            false
                        )
                        dataLocal.insertDetailTvshow(modelTvshow)
                    }
                }
            }
        }.forLiveData()
    }

    override fun getDataTvshowFav(): LiveData<PagedList<ModelTvshow>> {
        val setting = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(dataLocal.getFavTv(), setting).build()
    }

    override fun setDataTvshowFav(modelTvshow: ModelTvshow, boolean: Boolean) {
        deputy.diskIO().execute() {
            dataLocal.selectMovTv(modelTvshow, boolean)
        }
    }

}