package com.example.submission1_filmapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.submission1_filmapplication.`object`.MovTvDao
import com.example.submission1_filmapplication.model.ModelMov
import com.example.submission1_filmapplication.model.ModelTvshow

@Database(entities = [ModelMov::class, ModelTvshow::class], version = 1, exportSchema = false)
abstract class DatabaseFav : RoomDatabase() {

    abstract fun movTvDao(): MovTvDao

    companion object {
        @Volatile
        private var instance: DatabaseFav? = null

        fun forInstance(context: Context): DatabaseFav = instance ?: synchronized(this) {
            Room.databaseBuilder(context.applicationContext, DatabaseFav::class.java, "Database.db")
                .build().apply { instance = this }
        }
    }
}