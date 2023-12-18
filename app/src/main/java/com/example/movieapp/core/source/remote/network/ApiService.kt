package com.example.movieapp.core.source.remote.network

import com.example.movieapp.core.model.GenreModel
import com.example.movieapp.core.model.MovieModel
import com.example.movieapp.core.model.User
import com.example.movieapp.core.source.remote.request.LoginRequest
import com.example.movieapp.core.source.remote.response.base.GenreRespon
import com.example.movieapp.core.source.remote.response.base.BaseList
import com.example.movieapp.core.source.remote.response.base.BaseSingle
import com.example.movieapp.core.source.remote.response.base.DataRespon
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body user: LoginRequest
    ): Response<DataRespon<User>>

    @GET("/3/movie/popular?api_key=52b8bd92b56b7b49c4ddaaf85ece60d2")
    suspend fun getPopuler(): Response<BaseList<MovieModel>>

    @GET("/3/movie/top_rated?api_key=52b8bd92b56b7b49c4ddaaf85ece60d2")
    suspend fun getListMovie(): Response<BaseList<MovieModel>>

    @GET("/3/movie/upcoming?api_key=52b8bd92b56b7b49c4ddaaf85ece60d2")
    suspend fun getUpcoming(): Response<BaseList<MovieModel>>


    @GET("3/genre/movie/list?api_key=52b8bd92b56b7b49c4ddaaf85ece60d2")
    suspend fun getGenre(): Response<GenreRespon<GenreModel>>

}