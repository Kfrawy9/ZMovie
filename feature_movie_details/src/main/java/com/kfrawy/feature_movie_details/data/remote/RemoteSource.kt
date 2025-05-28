package com.kfrawy.feature_movie_details.data.remote

import com.kfrawy.core.component.model.Cast
import com.kfrawy.core.component.model.Image
import com.kfrawy.core.component.model.Review
import com.kfrawy.core.component.model.Video
import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import com.kfrawy.feature_movie_details.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface RemoteSource {

    fun getMovieDetails(seriesId: Int): Flow<com.kfrawy.core.utils.Result<MovieDetail>>
    fun getMovieCasts(seriesId: Int): Flow<com.kfrawy.core.utils.Result<List<Cast>>>
    fun getMovieReviews(seriesId: Int): Flow<com.kfrawy.core.utils.Result<List<Review>>>
    fun getMovieImages(seriesId: Int): Flow<com.kfrawy.core.utils.Result<List<Image>>>
    fun getMovieVideo(seriesId: Int): Flow<com.kfrawy.core.utils.Result<List<Video>>>
    fun getMovieRecommendation(seriesId: Int): Flow<com.kfrawy.core.utils.Result<List<Movie>>>
    fun getSimilarMovie(seriesId: Int): Flow<Result<List<Movie>>>
}