package com.kfrawy.feature_series.domain.usecase

import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Series
import kotlinx.coroutines.flow.Flow

interface SeriesUseCase {

    operator fun invoke(): Flow<Result<List<Series>>>

}