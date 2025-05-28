package com.kfrawy.feature_movie_details.domain.repository

import com.kfrawy.core.component.model.Cast
import com.kfrawy.core.component.model.Image
import com.kfrawy.core.component.model.Review
import com.kfrawy.core.component.model.Video
import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import com.kfrawy.feature_movie_details.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MovieDetailRepository {

    fun getMovieDetails(movieId: Int): Flow<com.kfrawy.core.utils.Result<MovieDetail>>
    fun getMovieCasts(movieId: Int): Flow<com.kfrawy.core.utils.Result<List<Cast>>>
    fun getMovieReviews(movieId: Int): Flow<com.kfrawy.core.utils.Result<List<Review>>>
    fun getMovieVideo(movieId: Int): Flow<com.kfrawy.core.utils.Result<List<Video>>>
    fun getMovieImages(movieId: Int): Flow<Result<List<Image>>>
    fun getMovieRecommendation(movieId: Int): Flow<com.kfrawy.core.utils.Result<List<Movie>>>
    fun getSimilarMovie(movieId: Int): Flow<Result<List<Movie>>>

}