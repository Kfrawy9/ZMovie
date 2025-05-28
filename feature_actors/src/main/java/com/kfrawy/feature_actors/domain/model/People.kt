package com.kfrawy.feature_actors.domain.model

data class People(
    val id: Int,
    val gender: Int,
    val known_for_department: String,
    val name: String,
    val profile_path: String?,
    val popularity: Double,
    val original_name: String,
    val known_for: List<KnownFor>,
)

data class KnownFor(
    val id: Int,
    val title: String?= "",
    val poster_path: String?,
    val backdrop_path: String?,
    val overview: String,
    val media_type: String,
    val vote_average: Double,
    val original_language: String,
    val genre_ids: List<Int>,
    val release_date: String?= "",
    val popularity: Double,
    val vote_count: Int,
)

data class PeopleResult(
    val page: Int,
    val results: List<People>,
) {}