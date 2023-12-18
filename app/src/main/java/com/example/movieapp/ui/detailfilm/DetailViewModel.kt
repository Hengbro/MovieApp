package com.example.movieapp.ui.detailfilm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.movieapp.core.repo.GenreRepository

class DetailViewModel (private val repository: GenreRepository) : ViewModel() {

    fun getGenre() = repository.getGenre().asLiveData()

}