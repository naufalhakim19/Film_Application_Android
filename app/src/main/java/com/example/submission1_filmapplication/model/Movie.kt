package com.example.submission1_filmapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Movie(
        var id: String,
        var title: String,
        var desc: String,
        var rating: String,
        var img: String
) : Parcelable
