package com.example.movieapp.util
fun String?.defaultError(): String{
    return this?: Constans.DEFAULT_ERROR
}

fun String.toUrlImage(): String{
    return "https://image.tmdb.org/t/p/w500/" + this
}