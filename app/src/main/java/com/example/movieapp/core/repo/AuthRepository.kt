package com.example.movieapp.core.repo

import com.example.movieapp.core.model.User
import com.example.movieapp.core.source.local.LocalDataSource
import com.example.movieapp.core.source.remote.network.ApiService
import com.example.movieapp.core.source.remote.network.ResponseHandler
import com.example.movieapp.core.source.remote.request.LoginRequest
import com.example.movieapp.core.source.remote.response.base.DataRespon
import com.example.movieapp.util.Prefs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class AuthRepository(val local: LocalDataSource, val remote: ApiService) {

    fun login(mData: LoginRequest) = object : ResponseHandler<User, DataRespon<User>>() {
        override suspend fun createCall(): Response<DataRespon<User>> {
            return remote.login(mData)
        }

        override suspend fun resultCall(data: DataRespon<User>): User {
            val user = data.data ?: User()
            Prefs.isLogin = true
            return user
        }
    }.asFlow().flowOn(Dispatchers.IO)

}