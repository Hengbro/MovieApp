package com.example.movieapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.movieapp.core.repo.MovieRepository

class HomeViewModel (private val repository: MovieRepository) : ViewModel() {

    fun getPopuler() = repository.getPopuler().asLiveData()
    fun getListMovie() = repository.getListMovie().asLiveData()
    fun getUpcoming() = repository.getUpcoming().asLiveData()

}