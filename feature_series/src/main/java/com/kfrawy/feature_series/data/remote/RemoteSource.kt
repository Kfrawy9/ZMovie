package com.kfrawy.feature_series.data.remote

import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import com.kfrawy.data.model.Series
import kotlinx.coroutines.flow.Flow

interface RemoteSource {

    fun getTrendingShow(): Flow<Result<List<Series>>>
    fun getAiringTodayShow(): Flow<Result<List<Series>>>
    fun getPopularShow(): Flow<Result<List<Series>>>
    fun getTopRatedShow(): Flow<Result<List<Series>>>
    fun getOnTheAirShow(): Flow<Result<List<Series>>>

}