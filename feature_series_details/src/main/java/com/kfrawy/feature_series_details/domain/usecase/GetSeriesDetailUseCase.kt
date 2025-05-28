package com.kfrawy.feature_series_details.domain.usecase

import com.kfrawy.core.utils.Result
import com.kfrawy.feature_series_details.domain.model.SeriesDetail
import com.kfrawy.feature_series_details.domain.repository.SeriesDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSeriesDetailUseCase @Inject constructor(val repo: SeriesDetailRepository) {
      operator fun invoke(seriesId: Int): Flow<Result<SeriesDetail>>{
         return repo.getSeriesDetails(seriesId)
     }
}