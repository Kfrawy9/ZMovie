package com.kfrawy.zmovie.utils

import kotlinx.serialization.Serializable

@Serializable
object MovieRoute

@Serializable
object SeriesRoute

@Serializable
object WatchListRoute

@Serializable
object ActorRoute

@Serializable
data class MovieDetail(val movieId: Int)

@Serializable
data class SeriesDetail(val seriesId: Int)

@Serializable
object ActorDetail

val routes = listOf(MovieRoute, SeriesRoute, WatchListRoute, ActorRoute)