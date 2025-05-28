package com.kfrawy.feature_watchlist.domain.usecase

import com.kfrawy.data.model.Show
import com.kfrawy.data.repository.local.ZMovieRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetWatchListUseCase @Inject constructor(val zMovieRepository: ZMovieRepository) {

    fun invoke(): Flow<List<Show>> = zMovieRepository.getWatchlist()

}