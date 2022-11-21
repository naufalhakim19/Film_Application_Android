package com.example.submission1_filmapplication.model

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.submission1_filmapplication.RepositoryMov
import com.example.submission1_filmapplication.`object`.Repository

class ViewModelFactory private constructor(private val repositoryMov: RepositoryMov) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(Repository.forRepository(context)).apply {
                instance = this
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainMovieModel::class.java) -> {
                MainMovieModel(repositoryMov) as T
            }

            modelClass.isAssignableFrom(DetailModel::class.java) -> {
                DetailModel(repositoryMov) as T
            }

            modelClass.isAssignableFrom(MainTvModel::class.java) -> {
                MainTvModel(repositoryMov) as T
            }

            modelClass.isAssignableFrom(FavoriteModel::class.java) -> {
                FavoriteModel(repositoryMov) as T
            }
            else -> throw Throwable("Not Found ViewModel class: " + modelClass.name)
        }
    }

}