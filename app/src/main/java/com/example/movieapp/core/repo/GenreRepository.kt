package com.example.movieapp.core.repo

import com.example.movieapp.core.source.local.LocalDataSource
import com.example.movieapp.core.source.remote.network.Resource
import com.example.movieapp.core.source.remote.response.RemoteDataSource
import com.inyongtisto.myhelper.extension.getErrorBody
import kotlinx.coroutines.flow.flow

class GenreRepository (local: LocalDataSource, val remote: RemoteDataSource) {

    fun getGenre() = flow {
        emit(Resource.loading(null))
        try {
            remote.getGenre().let {
                if (it.isSuccessful) {
                    val body = it.body()
                    val data = body?.genres
                    emit(Resource.success(data))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.orEmpty(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.orEmpty(), null))
        }
    }
}