package com.kfrawy.feature_movie.data.repository

import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import com.kfrawy.feature_movie.data.RemoteSource
import com.kfrawy.feature_movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(val remoteSource: RemoteSource): MovieRepository {

    override suspend fun getTrendingMovies(): Flow<Result<List<Movie>>> {
        return remoteSource.getTrendingMovies()
    }

    override suspend fun getUpComingMovies(): Flow<Result<List<Movie>>> {
        return remoteSource.getUpComingMovies()
    }

    override suspend fun getPopularMovies(): Flow<Result<List<Movie>>> {
        return remoteSource.getPopularMovies()
    }

    override suspend fun getTopRatedMovies(): Flow<Result<List<Movie>>> {
        return remoteSource.getTopRatedMovies()
    }

    override suspend fun getNowPlayingMovies(): Flow<Result<List<Movie>>> {
        return remoteSource.getNowPlayingMovies()
    }
}