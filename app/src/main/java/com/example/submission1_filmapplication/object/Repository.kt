package com.example.submission1_filmapplication.`object`

import android.content.Context
import com.example.submission1_filmapplication.Deputy
import com.example.submission1_filmapplication.JsonHelper
import com.example.submission1_filmapplication.RemoteForData
import com.example.submission1_filmapplication.RepositoryMov
import com.example.submission1_filmapplication.data.DataLocal
import com.example.submission1_filmapplication.data.DatabaseFav

object Repository {

    fun forRepository(context: Context): RepositoryMov {
        val database = DatabaseFav.forInstance(context)
        val dataLocal = DataLocal.getInstance(database.movTvDao())
        val remoteData = RemoteForData.getDataInstance(JsonHelper(context))
        val deputy = Deputy()
        return RepositoryMov.getInstance(remoteData,dataLocal,deputy)
    }

}