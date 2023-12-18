package com.example.movieapp.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenreModel(
    val id: Int,
    val name: String
): Parcelable