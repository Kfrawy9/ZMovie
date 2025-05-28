package com.kfrawy.feature_watchlist.domain.usecase

import com.kfrawy.data.model.Show
import com.kfrawy.data.repository.local.ZMovieRepository
import javax.inject.Inject

class DeleteMovieUseCase @Inject constructor(val zMovieRepository: ZMovieRepository) {

    suspend fun invoke(show: Show){
        zMovieRepository.delete(show)
    }

}