package com.kfrawy.feature_series_details.domain.usecase

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.kfrawy.core.component.model.HorizontalData
import com.kfrawy.core.component.model.ViewState
import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import com.kfrawy.data.model.Series
import com.kfrawy.feature_series_details.domain.repository.SeriesDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

class GetRecommendationUseCase @Inject constructor(val repo: SeriesDetailRepository) {
      operator fun invoke(seriesId: Int): Flow<Result<List<Series>>>{
         return repo.getSeriesRecommendation(seriesId)
     }
}