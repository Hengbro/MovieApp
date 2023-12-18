package com.example.movieapp.core.di

import com.example.movieapp.ui.auth.AuthViewModel
import com.example.movieapp.ui.dashboard.DashboardViewModel
import com.example.movieapp.ui.detailfilm.DetailViewModel
import com.example.movieapp.ui.home.HomeViewModel
import com.example.movieapp.ui.notifications.NotificationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DashboardViewModel(get()) }
    viewModel { NotificationsViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { AuthViewModel(get()) }
}
