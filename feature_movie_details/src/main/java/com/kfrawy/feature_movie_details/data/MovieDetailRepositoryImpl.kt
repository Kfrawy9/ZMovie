package com.kfrawy.feature_movie_details.data

import com.kfrawy.core.component.model.Cast
import com.kfrawy.core.component.model.Image
import com.kfrawy.core.component.model.Review
import com.kfrawy.core.component.model.Video
import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import com.kfrawy.feature_movie_details.domain.model.MovieDetail
import com.kfrawy.feature_movie_details.data.remote.RemoteSource
import com.kfrawy.feature_movie_details.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(val remoteSource: RemoteSource): MovieDetailRepository {

    override fun getMovieDetails(movieId: Int): Flow<Result<MovieDetail>> {
        return remoteSource.getMovieDetails(movieId)
    }

    override fun getMovieVideo(movieId: Int): Flow<Result<List<Video>>> {
        return remoteSource.getMovieVideo(movieId)
    }

    override fun getMovieCasts(movieId: Int): Flow<Result<List<Cast>>> {
        return remoteSource.getMovieCasts(movieId)
    }

    override fun getMovieReviews(movieId: Int): Flow<Result<List<Review>>> {
        return remoteSource.getMovieReviews(movieId)
    }

    override fun getMovieImages(movieId: Int): Flow<Result<List<Image>>> {
        return remoteSource.getMovieImages(movieId)
    }

    override fun getMovieRecommendation(movieId: Int): Flow<Result<List<Movie>>> {
        return remoteSource.getMovieRecommendation(movieId)
    }

    override fun getSimilarMovie(movieId: Int): Flow<Result<List<Movie>>> {
        return remoteSource.getSimilarMovie(movieId)
    }
}