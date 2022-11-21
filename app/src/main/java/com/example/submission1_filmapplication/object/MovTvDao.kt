package com.example.submission1_filmapplication.`object`

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.submission1_filmapplication.model.ModelMov
import com.example.submission1_filmapplication.model.ModelTvshow

@Dao
interface MovTvDao {
    @Query("SELECT * FROM entitiesdatamovie")
    fun getDataMovie(): DataSource.Factory<Int, ModelMov>

    @Query("SELECT * FROM entitiesdatamovie where favorite = 1")
    fun getDataMovieFav(): DataSource.Factory<Int, ModelMov>

    @Query("SELECT * FROM entitiesdatamovie where id = :id")
    fun getDataMovieId(id: String): LiveData<ModelMov>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun putDataMovie(modelMov: List<ModelMov>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun putDataDetailMovie(modelMov: ModelMov)

    @Update
    fun updateDataMovie(modelMov: ModelMov)


    @Query("SELECT * FROM entitiesdatatvshow")
    fun getDataTvshow(): DataSource.Factory<Int, ModelTvshow>

    @Query("SELECT * FROM entitiesdatatvshow where favorite = 1")
    fun getDataTvshowFav(): DataSource.Factory<Int, ModelTvshow>

    @Query("SELECT * FROM entitiesdatatvshow where id = :id")
    fun getDataTvshowId(id: String): LiveData<ModelTvshow>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun putDataTvshow(modelTvshow: List<ModelTvshow>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun putDataDetailTvshow(modelTvshow: ModelTvshow)

    @Update
    fun updateDataTvshow(modelTvshow: ModelTvshow)
}