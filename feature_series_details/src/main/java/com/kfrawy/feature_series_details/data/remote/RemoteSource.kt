package com.kfrawy.feature_series_details.data.remote

import com.kfrawy.core.component.model.Cast
import com.kfrawy.core.component.model.Image
import com.kfrawy.core.component.model.Review
import com.kfrawy.core.component.model.Video
import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import com.kfrawy.data.model.Series
import com.kfrawy.feature_series_details.domain.model.SeriesDetail
import kotlinx.coroutines.flow.Flow

interface RemoteSource {

    fun getSeriesDetails(seriesId: Int): Flow<Result<SeriesDetail>>
    fun getSeriesCasts(seriesId: Int): Flow<Result<List<Cast>>>
    fun getSeriesReviews(seriesId: Int): Flow<Result<List<Review>>>
    fun getSeriesImages(seriesId: Int): Flow<Result<List<Image>>>
    fun getSeriesVideo(seriesId: Int): Flow<Result<List<Video>>>
    fun getSeriesRecommendation(seriesId: Int): Flow<Result<List<Series>>>
    fun getSimilarSeries(seriesId: Int): Flow<Result<List<Series>>>

}