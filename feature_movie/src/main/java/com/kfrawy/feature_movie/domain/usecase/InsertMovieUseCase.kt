package com.kfrawy.feature_movie.domain.usecase

import com.kfrawy.data.model.Show
import com.kfrawy.data.repository.local.ZMovieRepository
import javax.inject.Inject

class InsertMovieUseCase @Inject constructor(val zMovieRepository: ZMovieRepository) {

    suspend operator fun invoke(show: Show){
        zMovieRepository.insert(show)
    }

}