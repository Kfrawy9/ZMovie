package com.kfrawy.feature_series_details.domain.usecase

import com.kfrawy.core.component.model.Review
import com.kfrawy.core.utils.Result
import com.kfrawy.feature_series_details.domain.repository.SeriesDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetReviewsUseCase @Inject constructor(val repo: SeriesDetailRepository) {
    operator fun invoke(seriesId: Int): Flow<Result<List<Review>>>{
         return repo.getSeriesReviews(seriesId)
     }
}