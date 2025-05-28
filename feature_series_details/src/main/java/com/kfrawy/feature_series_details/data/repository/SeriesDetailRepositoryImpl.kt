package com.kfrawy.feature_series_details.data.repository

import com.kfrawy.core.component.model.Cast
import com.kfrawy.core.component.model.Image
import com.kfrawy.core.component.model.Review
import com.kfrawy.core.component.model.Video
import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Series
import com.kfrawy.feature_series_details.data.remote.RemoteSource
import com.kfrawy.feature_series_details.domain.model.SeriesDetail
import com.kfrawy.feature_series_details.domain.repository.SeriesDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SeriesDetailRepositoryImpl @Inject constructor(val remoteSource: RemoteSource): SeriesDetailRepository {

    override fun getSeriesDetails(seriesId: Int): Flow<Result<SeriesDetail>> {
        return remoteSource.getSeriesDetails(seriesId)
    }

    override fun getSeriesCasts(seriesId: Int): Flow<Result<List<Cast>>> {
        return remoteSource.getSeriesCasts(seriesId)
    }

    override fun getSeriesReviews(seriesId: Int): Flow<Result<List<Review>>> {
        return remoteSource.getSeriesReviews(seriesId)
    }

    override fun getSeriesImages(seriesId: Int): Flow<Result<List<Image>>> {
        return remoteSource.getSeriesImages(seriesId)
    }

    override fun getSeriesVideo(seriesId: Int): Flow<Result<List<Video>>> {
        return remoteSource.getSeriesVideo(seriesId)
    }

    override fun getSeriesRecommendation(seriesId: Int): Flow<Result<List<Series>>> {
        return remoteSource.getSeriesRecommendation(seriesId)
    }

    override fun getSimilarSeries(seriesId: Int): Flow<Result<List<Series>>> {
        return remoteSource.getSimilarSeries(seriesId)
    }
}