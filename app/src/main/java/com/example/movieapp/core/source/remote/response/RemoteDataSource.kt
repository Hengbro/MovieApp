package com.example.movieapp.core.source.remote.response

import com.example.movieapp.core.source.remote.network.ApiService

class RemoteDataSource(val api: ApiService) {

    suspend fun  getPopuler() = api.getPopuler()
    suspend fun  getListMovie() = api.getListMovie()
    suspend fun  getUpcoming() = api.getUpcoming()

    suspend fun getGenre()= api.getGenre()
}