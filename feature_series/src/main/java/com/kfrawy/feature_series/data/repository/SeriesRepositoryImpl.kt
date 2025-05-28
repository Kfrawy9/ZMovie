package com.kfrawy.feature_series.data.repository

import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Series
import com.kfrawy.feature_series.data.remote.RemoteSource
import com.kfrawy.feature_series.domain.repository.SeriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SeriesRepositoryImpl @Inject constructor(val remoteSource: RemoteSource): SeriesRepository {

    override fun getTrendingShow(): Flow<Result<List<Series>>> {
        return remoteSource.getTrendingShow()
    }

    override fun getAiringTodayShow(): Flow<Result<List<Series>>> {
        return remoteSource.getAiringTodayShow()
    }

    override fun getPopularShow(): Flow<Result<List<Series>>> {
        return remoteSource.getPopularShow()
    }

    override fun getTopRatedShow(): Flow<Result<List<Series>>> {
        return remoteSource.getTopRatedShow()
    }

    override fun getOnTheAirShow(): Flow<Result<List<Series>>> {
        return remoteSource.getOnTheAirShow()
    }
}