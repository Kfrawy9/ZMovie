package com.kfrawy.feature_movie_details.domain.model

data class MovieDetail(
    val id: Int = 0,
    val original_title:String = "",
    val popularity: Double = 0.0,
    val poster_path: String? = null,
    val release_date: String = "2025:5:5",
    val vote_average: Double = 0.0,
    val original_language: String = "En",
    val overview: String = "No OverView",
    val runtime: Int = 0,
    val status: String = "",
    val tagline: String = "No Tag",
)