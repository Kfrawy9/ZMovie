package com.kfrawy.feature_series.domain.usecase

import com.kfrawy.data.model.Series
import com.kfrawy.core.utils.Result
import com.kfrawy.feature_series.domain.repository.SeriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTrendingShow @Inject constructor(val repository: SeriesRepository): SeriesUseCase {

    override operator fun invoke(): Flow<Result<List<Series>>> =
        repository.getTrendingShow()
}