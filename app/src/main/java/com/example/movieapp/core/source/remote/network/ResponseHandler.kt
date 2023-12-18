package com.example.movieapp.core.source.remote.network

import com.example.movieapp.util.Constans.DEFAULT_ERROR
import com.inyongtisto.myhelper.extension.getErrorBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

abstract class ResponseHandler<ResultType, RequestType : Any> {
    private val result: Flow<Resource<ResultType>> = flow {
        emit(Resource.loading(null))
        try {
            val apiResponse = createCall()
            when {
                apiResponse.isSuccessful -> {
                    val result = resultCall(apiResponse.body()!!)
                    emit(Resource.success(result))
                }
                else -> {
                    onFetchFailed()
                    val error = apiResponse.getErrorBody()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun String?.convertErrorMessage(): String {
        return when (this) {
            "unexpected end of stream" -> "Internal Server Error"
            null -> DEFAULT_ERROR
            else -> DEFAULT_ERROR
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract suspend fun createCall(): Response<RequestType>

    protected abstract suspend fun resultCall(data: RequestType): ResultType

    fun asFlow(): Flow<Resource<ResultType>> = result
}