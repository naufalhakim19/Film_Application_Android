package com.example.submission1_filmapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.submission1_filmapplication.data.Api
import com.example.submission1_filmapplication.data.StatusInfo

abstract class NetworkBoundAsset<ResultType, RequestType>(private val deputy: Deputy) {

    private val result = MediatorLiveData<Asset<ResultType>>()

    init {
        result.value = Asset.loading(null)

        val dbSource = loadfromDb()

        result.addSource(dbSource) { db ->
            result.removeSource(dbSource)
            if (bring(db)) {
                bringFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { newDb ->
                    result.value = Asset.success(newDb)
                }
            }
        }
    }

    protected fun onBringFailed() {}

    protected abstract fun bring(data: ResultType?): Boolean

    protected abstract fun createCall(): LiveData<Api<RequestType>>

    protected abstract fun saveCallResult(data: RequestType)

    protected abstract fun loadfromDb(): LiveData<ResultType>

    private fun bringFromNetwork(dbSource: LiveData<ResultType>) {

        val api = createCall()

        result.addSource(dbSource) { newData ->
            result.value = Asset.loading(newData)
        }

        result.addSource(api) { reply ->
            result.removeSource(api)
            result.removeSource(dbSource)

            when (reply.status) {
                StatusInfo.SUCCESS ->
                    deputy.diskIO().execute {
                        saveCallResult(reply.body)

                        deputy.mainThread().execute {
                            result.addSource(loadfromDb()) { newData ->
                                result.value = Asset.success(newData)
                            }
                        }
                    }
                StatusInfo.ERROR -> {
                    onBringFailed()
                    result.addSource(dbSource) { newData ->
                        result.value = Asset.error(reply.message, newData)
                    }
                }
            }
        }
    }

    fun forLiveData(): LiveData<Asset<ResultType>> = result
}
