package com.kfrawy.feature_series_details.domain.usecase

import com.kfrawy.core.component.model.Cast
import com.kfrawy.core.utils.Result
import com.kfrawy.feature_series_details.domain.repository.SeriesDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCreditsUseCase @Inject constructor(val repo: SeriesDetailRepository) {
      operator fun invoke(seriesId: Int): Flow<Result<List<Cast>>>{
         return repo.getSeriesCasts(seriesId)
     }
}