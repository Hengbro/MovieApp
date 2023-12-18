package com.example.movieapp.core.di

import androidx.room.Room
import com.example.movieapp.core.source.local.AppDatabase
import com.example.movieapp.core.source.remote.response.RemoteDataSource
import com.example.movieapp.core.source.local.LocalDataSource
import com.example.movieapp.core.source.remote.network.ApiConfig
import com.example.movieapp.util.Constans
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            Constans.DB_NAME
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { ApiConfig.provideApiService }

    single { RemoteDataSource(get()) }

    single { LocalDataSource(get()) }

}