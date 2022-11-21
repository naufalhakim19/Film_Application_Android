package com.example.submission1_filmapplication.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelDataRepMov(
    var id: String,
    var title: String,
    var desc: String,
    var rating: String,
    var img: String,
    var fav: Boolean = false
) : Parcelable