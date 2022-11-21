package com.example.submission1_filmapplication

import android.content.Context
import com.example.submission1_filmapplication.data.ModelDataRepMov
import com.example.submission1_filmapplication.data.ModelDataRepTvshow
import com.example.submission1_filmapplication.model.ModelTvshow
import com.example.submission1_filmapplication.model.Movie
import com.example.submission1_filmapplication.model.TvShow
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun pasFileName(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }


    fun loadMov(): List<ModelDataRepMov> {
        val datalist = ArrayList<ModelDataRepMov>()

        try {
            val objectResponse = JSONObject(pasFileName("Movie.json").toString())
            val arrayList = objectResponse.getJSONArray("movie")
            for (i in 0 until arrayList.length()) {
                val movie = arrayList.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val desc = movie.getString("desc")
                val rating = movie.getString("rating")
                val img = movie.getString("img")

                val dataMovie = ModelDataRepMov(id, title, desc, rating, img)
                datalist.add(dataMovie)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return datalist
    }

    private fun pasFileNameTv(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }


    fun loadTv(): List<ModelDataRepTvshow> {
        val datalist = ArrayList<ModelDataRepTvshow>()

        try {
            val objectResponse = JSONObject(pasFileNameTv("Tvshow.json").toString())
            val arrayList = objectResponse.getJSONArray("tvshow")
            for (i in 0 until arrayList.length()) {
                val movie = arrayList.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val desc = movie.getString("desc")
                val rating = movie.getString("rating")
                val img = movie.getString("img")

                val dataTv = ModelDataRepTvshow(id, title, desc, rating, img)
                datalist.add(dataTv)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return datalist
    }

}