package com.example.movieapp.util

import com.chibatching.kotpref.KotprefModel

object Prefs : KotprefModel() {
    var isLogin by booleanPref(false)
}
