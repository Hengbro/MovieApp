package com.example.movieapp.core.source.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class AuthEntity(
    @PrimaryKey
    var id: Int = 0,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
    var phone: String? = null
): Parcelable
