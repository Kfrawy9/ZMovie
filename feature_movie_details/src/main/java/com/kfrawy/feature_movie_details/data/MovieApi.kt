package com.kfrawy.feature_movie_details.data

import com.kfrawy.core.component.model.Cast
import com.kfrawy.core.component.model.CastResult
import com.kfrawy.core.component.model.Image
import com.kfrawy.core.component.model.ImageResult
import com.kfrawy.core.component.model.ReviewResult
import com.kfrawy.core.component.model.Video
import com.kfrawy.core.component.model.VideoResult
import com.kfrawy.data.model.Movie
import com.kfrawy.data.model.MovieResponse
import com.kfrawy.feature_movie_details.domain.model.MovieDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{movieId}")
    suspend fun getMovieDetail(@Path("movieId") movieId: Int): Response<MovieDetail>

    @GET("movie/{movieId}}/credits")
    suspend fun getMovieCredits(@Path("movieId") movieId: Int): Response<CastResult>

    @GET("movie/{movieId}/videos")
    suspend fun getMovieVideos(@Path("movieId") movieId: Int): Response<VideoResult>

    @GET("movie/{movieId}/images")
    suspend fun getMovieImages(@Path("movieId") movieId: Int): Response<ImageResult>

    @GET("movie/{movieId}/reviews")
    suspend fun getMovieReview(@Path("movieId") movieId: Int, @Query("page") page: Int): Response<ReviewResult>

    @GET("movie/{movieId}/similar")
    suspend fun getSimilarMovies(@Path("movieId") movieId: Int, @Query("page") page: Int): Response<MovieResponse<Movie>>

    @GET("movie/{movieId}/recommendations")
    suspend fun getRecommendationsMovies(@Path("movieId") movieId: Int, @Query("page") page: Int): Response<MovieResponse<Movie>>


}