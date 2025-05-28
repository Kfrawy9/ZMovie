package com.kfrawy.feature_series_details.domain.usecase

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.kfrawy.core.component.model.Image
import com.kfrawy.core.component.model.ViewState
import com.kfrawy.core.utils.Result
import com.kfrawy.feature_series_details.domain.repository.SeriesDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetImageUseCase @Inject constructor(val repo: SeriesDetailRepository) {
      operator fun invoke(movieId: Int): Flow<Result<List<Image>>>{
         return repo.getSeriesImages(movieId)
     }
}