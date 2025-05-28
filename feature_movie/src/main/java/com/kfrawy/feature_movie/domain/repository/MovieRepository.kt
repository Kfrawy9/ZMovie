package com.kfrawy.feature_movie.domain.repository

import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getTrendingMovies(): Flow<Result<List<Movie>>>
    suspend fun getUpComingMovies(): Flow<Result<List<Movie>>>
    suspend fun getPopularMovies(): Flow<Result<List<Movie>>>
    suspend fun getTopRatedMovies(): Flow<Result<List<Movie>>>
    suspend fun getNowPlayingMovies(): Flow<Result<List<Movie>>>

}