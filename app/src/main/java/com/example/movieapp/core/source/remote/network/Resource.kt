package com.example.movieapp.core.source.remote.network

import com.example.movieapp.util.Constans


data class Resource<out T>(
    val state: State, val results: T?, val message: String? = null, val errorCode: String? = null) {

    companion object {

        fun  <T> success(data: T?): Resource<T> {
            return Resource(State.SUCCESS, data, null)
        }

        fun  <T> error(msg: String, data: T?): Resource<T> {
            return Resource(State.ERROR, data, msg)
        }

        fun  <T> loading(data: T?): Resource<T> {
            return Resource(State.LOADING, data, null)
        }

    }
}