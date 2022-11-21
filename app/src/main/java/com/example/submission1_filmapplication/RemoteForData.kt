package com.example.submission1_filmapplication

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.submission1_filmapplication.`object`.Idling
import com.example.submission1_filmapplication.data.Api
import com.example.submission1_filmapplication.data.ModelDataRepMov
import com.example.submission1_filmapplication.data.ModelDataRepTvshow
import com.example.submission1_filmapplication.model.Movie
import com.example.submission1_filmapplication.model.TvShow


class RemoteForData private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val TIME: Long = 2000

        @Volatile
        private var instance: RemoteForData? = null

        fun getDataInstance(helper: JsonHelper): RemoteForData = instance ?: synchronized(this) {
            instance ?: RemoteForData(helper).apply { instance = this }
        }
    }

    fun getDataMovie(): LiveData<Api<List<ModelDataRepMov>>> {
        Idling.increment()
        val result = MutableLiveData<Api<List<ModelDataRepMov>>>()
        handler.postDelayed({
            result.value = Api.success(jsonHelper.loadMov())
            Idling.decrement()
        }, TIME)
        return result
    }


    fun getDataTv(): LiveData<Api<List<ModelDataRepTvshow>>> {
        Idling.increment()
        val result = MutableLiveData<Api<List<ModelDataRepTvshow>>>()
        handler.postDelayed({
            result.value = Api.success(jsonHelper.loadTv())
            Idling.decrement()
        }, TIME)
        return result
    }

}

