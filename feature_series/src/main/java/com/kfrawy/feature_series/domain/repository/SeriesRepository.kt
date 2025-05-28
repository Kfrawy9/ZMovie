package com.kfrawy.feature_series.domain.repository

import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Series
import kotlinx.coroutines.flow.Flow

interface SeriesRepository {

    fun getTrendingShow(): Flow<Result<List<Series>>>
    fun getAiringTodayShow(): Flow<Result<List<Series>>>
    fun getPopularShow(): Flow<Result<List<Series>>>
    fun getTopRatedShow(): Flow<Result<List<Series>>>
    fun getOnTheAirShow(): Flow<Result<List<Series>>>
}