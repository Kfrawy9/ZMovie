package com.kfrawy.data.model

data class Series(
    val id: Int,
    val genre_ids: List<Int>,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val backdrop_path: String?,
    val first_air_date: String,
    val name: String = "",
    val vote_average: Double,
)
