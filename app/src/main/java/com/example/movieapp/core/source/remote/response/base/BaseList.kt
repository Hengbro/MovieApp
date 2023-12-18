package com.example.movieapp.core.source.remote.response.base

class BaseList <T>(
    val success: Int? =  null,
    val message: String? = null,
    val results: List<T> = emptyList()
)