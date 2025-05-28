package com.kfrawy.feature_series_details.domain.repository

import com.kfrawy.core.component.model.Cast
import com.kfrawy.core.component.model.Image
import com.kfrawy.core.component.model.Review
import com.kfrawy.core.component.model.Video
import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Series
import com.kfrawy.feature_series_details.domain.model.SeriesDetail
import kotlinx.coroutines.flow.Flow

interface SeriesDetailRepository {

    fun getSeriesDetails(movieId: Int): Flow<com.kfrawy.core.utils.Result<SeriesDetail>>
    fun getSeriesCasts(movieId: Int): Flow<com.kfrawy.core.utils.Result<List<Cast>>>
    fun getSeriesReviews(movieId: Int): Flow<com.kfrawy.core.utils.Result<List<Review>>>
    fun getSeriesImages(movieId: Int): Flow<com.kfrawy.core.utils.Result<List<Image>>>
    fun getSeriesVideo(movieId: Int): Flow<com.kfrawy.core.utils.Result<List<Video>>>
    fun getSeriesRecommendation(movieId: Int): Flow<com.kfrawy.core.utils.Result<List<Series>>>
    fun getSimilarSeries(movieId: Int): Flow<Result<List<Series>>>

}