package com.example.movieapp.core.repo

import com.example.movieapp.core.source.local.LocalDataSource
import com.example.movieapp.core.source.remote.network.Resource
import com.example.movieapp.core.source.remote.response.RemoteDataSource
import com.inyongtisto.myhelper.extension.getErrorBody
import kotlinx.coroutines.flow.flow

class MovieRepository(val local: LocalDataSource, val remote: RemoteDataSource) {


    fun getPopuler() = flow {
        emit(Resource.loading(null))
        try {
            remote.getPopuler().let {
                if (it.isSuccessful) {
                    val body = it.body()
                    val data = body?.results
                    emit(Resource.success(data))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.orEmpty(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.orEmpty(), null))
        }
    }

    fun getListMovie() = flow {
        emit(Resource.loading(null))
        try {
            remote.getListMovie().let {
                if (it.isSuccessful) {
                    val body = it.body()
                    val data = body?.results
                    emit(Resource.success(data))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.orEmpty(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.orEmpty(), null))
        }
    }

    fun getUpcoming() = flow {
        emit(Resource.loading(null))
        try {
            remote.getUpcoming().let {
                if (it.isSuccessful) {
                    val body = it.body()
                    val data = body?.results
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