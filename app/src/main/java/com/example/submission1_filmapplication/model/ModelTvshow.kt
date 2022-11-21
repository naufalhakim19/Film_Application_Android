package com.example.submission1_filmapplication.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entitiesdatatvshow")
data class ModelTvshow(
    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "description")
    var desc: String,

    @ColumnInfo(name = "rating")
    var rating: String,

    @ColumnInfo(name = "Image")
    var img: String,

    @ColumnInfo(name = "favorite")
    var fav: Boolean = false

)