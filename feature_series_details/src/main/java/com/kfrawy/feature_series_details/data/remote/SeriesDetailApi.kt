package com.kfrawy.feature_series_details.data.remote

import com.kfrawy.core.component.model.CastResult
import com.kfrawy.core.component.model.ImageResult
import com.kfrawy.core.component.model.ReviewResult
import com.kfrawy.core.component.model.VideoResult
import com.kfrawy.data.model.MovieResponse
import com.kfrawy.data.model.Series
import com.kfrawy.feature_series_details.domain.model.SeriesDetail
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SeriesDetailApi {

    @GET("tv/{seriesId}")
    suspend fun getSeriesDetail(@Path("seriesId") seriesId: Int): Response<SeriesDetail>

    @GET("tv/{seriesId}}/credits")
    suspend fun getSeriesCredits(@Path("seriesId") seriesId: Int): Response<CastResult>

    @GET("tv/{seriesId}/videos")
    suspend fun getSeriesVideos(@Path("seriesId") seriesId: Int): Response<VideoResult>

    @GET("tv/{seriesId}/images")
    suspend fun getSeriesImages(@Path("seriesId") seriesId: Int): Response<ImageResult>

    @GET("tv/{seriesId}/reviews")
    suspend fun getSeriesReview(@Path("seriesId") seriesId: Int, @Query("page") page: Int): Response<ReviewResult>

    @GET("tv/{seriesId}/similar")
    suspend fun getSimilarSeries(@Path("seriesId") seriesId: Int, @Query("page") page: Int): Response<MovieResponse<Series>>

    @GET("tv/{seriesId}/recommendations")
    suspend fun getRecommendationsSeries(@Path("seriesId") seriesId: Int, @Query("page") page: Int): Response<MovieResponse<Series>>


}