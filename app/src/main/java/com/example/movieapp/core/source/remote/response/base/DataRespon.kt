package com.example.movieapp.core.source.remote.response.base

data class DataRespon<T>(
    var message: String = "",
    var code: String = "",
    var data: T? = null
)