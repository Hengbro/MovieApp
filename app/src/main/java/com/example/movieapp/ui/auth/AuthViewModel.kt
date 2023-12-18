package com.example.movieapp.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.movieapp.core.repo.AuthRepository
import com.example.movieapp.core.source.remote.request.LoginRequest

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    fun login(data: LoginRequest) = repository.login(data).asLiveData()

}