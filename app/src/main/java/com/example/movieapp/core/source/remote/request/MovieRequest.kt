package com.example.movieapp.core.source.remote.request

class MovieRequest (
    var id: Int? = null,
    var title: String? = null,
    var backdrop_path: String? = null,
    val genre_ids: List<Int>,
    val popularity: Double? = null,
    val release_date: String? = null,
    val overview: String? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null,
)
