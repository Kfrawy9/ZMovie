package com.kfrawy.feature_series_details.domain.model

data class SeriesDetail(
    val first_air_date: String = "0000-00-00",
    val id: Int = 0,
    val in_producation: String = "",
    val languages: List<String> = emptyList(),
    val last_air_date: String = "",
    val name: String = "",
    val next_episode_to_air: String? = null,
    val number_of_episodes:Int = 0,
    val number_of_seasons:Int = 0,
    val original_language: String = "",
    val original_name: String = "",
    val overview: String = "",
    val poster_path: String? = null,
    val backdrop_path: String? = null,
    val popularity: Double = 0.0,
    val seasons: List<Season> = emptyList(),
    val status: String = "",
    val vote_average: Double = 0.0,
    val vote_count: Int = 0,
    val tagline: String = "",

)
