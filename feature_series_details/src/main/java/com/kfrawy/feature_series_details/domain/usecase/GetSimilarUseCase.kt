package com.kfrawy.feature_series_details.domain.usecase

import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import com.kfrawy.data.model.Series
import com.kfrawy.feature_series_details.domain.repository.SeriesDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSimilarUseCase @Inject constructor(val repo: SeriesDetailRepository) {
     suspend operator fun invoke(seriesId: Int): Flow<Result<List<Series>>>{
         return repo.getSimilarSeries(seriesId)
     }
}