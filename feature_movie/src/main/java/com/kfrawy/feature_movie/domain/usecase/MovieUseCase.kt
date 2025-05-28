package com.kfrawy.feature_movie.domain.usecase

import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    suspend operator fun invoke(): Flow<Result<List<Movie>>>
}