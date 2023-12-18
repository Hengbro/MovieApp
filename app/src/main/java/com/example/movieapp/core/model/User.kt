package com.example.movieapp.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var id: Int = 0,
    var name: String = "",
    var phone: String? = null,
    var email: String = "",
    var password: String = "",
    var updated_at: String = "",
    var created_at: String = "",
    var image: String? = null,
    var dummy: String? = null,
) : Parcelable