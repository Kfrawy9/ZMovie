package com.kfrawy.data.model


data class Movie(
    val id: Int,
    val genre_ids: List<Int>,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val release_date: String = "2020",
    val title: String,
    val video: Boolean,
    val vote_average: Double,
)

data class MovieResponse<T>(
    val page: Int,
    val results: List<T>,
)
