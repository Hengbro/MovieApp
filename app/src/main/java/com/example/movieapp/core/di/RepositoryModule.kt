package com.example.movieapp.core.di

import com.example.movieapp.core.repo.AuthRepository
import com.example.movieapp.core.repo.GenreRepository
import com.example.movieapp.core.repo.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AuthRepository(get(), get()) }
    single { MovieRepository(get(), get()) }
    single { GenreRepository(get(), get()) }
}
