package com.kfrawy.feature_series.domain.usecase

import com.kfrawy.data.model.Show
import com.kfrawy.data.repository.local.ZMovieRepository
import javax.inject.Inject

class DeleteSeriesUseCase @Inject constructor(val zMovieRepository: ZMovieRepository) {

    suspend operator fun invoke(show: Show){
        zMovieRepository.delete(show)
    }

}