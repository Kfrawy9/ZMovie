package com.kfrawy.feature_movie.domain.usecase

import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import com.kfrawy.feature_movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUpComingUseCase @Inject constructor(val repo: MovieRepository): MovieUseCase {
    override suspend operator fun invoke(): Flow<Result<List<Movie>>> {
        return repo.getUpComingMovies()
    }
}