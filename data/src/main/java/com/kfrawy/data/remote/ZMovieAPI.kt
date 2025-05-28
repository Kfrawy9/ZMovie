package com.kfrawy.data.remote

import com.kfrawy.data.model.Movie
import com.kfrawy.data.model.MovieResponse
import com.kfrawy.data.model.Series
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ZMovieAPI {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("page") page: Int): Response<MovieResponse<Movie>>

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): Response<MovieResponse<Movie>>

    @GET("movie/upcoming")
    suspend fun getUpComingMovies(@Query("page") page: Int): Response<MovieResponse<Movie>>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("page") page: Int): Response<MovieResponse<Movie>>

    @GET("trending/movie/day")
    suspend fun getTrendingMovies(@Query("page") page: Int): Response<MovieResponse<Movie>>



    @GET("tv/airing_today")
    suspend fun getAiringTodaySeries(@Query("page") page: Int): Response<MovieResponse<Series>>

    @GET("tv/on_the_air")
    suspend fun getOnTheAirSeries(@Query("page") page: Int): Response<MovieResponse<Series>>

    @GET("tv/popular")
    suspend fun getPopularSeries(@Query("page") page: Int): Response<MovieResponse<Series>>

    @GET("tv/top_rated")
    suspend fun getTopRatedSeries(@Query("page") page: Int): Response<MovieResponse<Series>>

    @GET("trending/tv/day")
    suspend fun getTrendingSeries(@Query("page") page: Int): Response<MovieResponse<Series>>


}