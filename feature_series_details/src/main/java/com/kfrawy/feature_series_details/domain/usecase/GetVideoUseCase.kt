package com.kfrawy.feature_series_details.domain.usecase

import com.kfrawy.core.component.model.Image
import com.kfrawy.core.component.model.Video
import com.kfrawy.core.utils.Result
import com.kfrawy.feature_series_details.domain.repository.SeriesDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

class GetVideoUseCase @Inject constructor(val repo: SeriesDetailRepository) {
      operator fun invoke(seriesId: Int): Flow<Result<List<Video>>>{
          return repo.getSeriesVideo(seriesId)
     }
}