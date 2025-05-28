package com.kfrawy.feature_movie_details.domain.usecase

import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import com.kfrawy.feature_movie_details.domain.model.MovieDetail
import com.kfrawy.feature_movie_details.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSimilarUseCase @Inject constructor(val repo: MovieDetailRepository) {
     suspend operator fun invoke(movieId: Int): Flow<Result<List<Movie>>>{
         return repo.getSimilarMovie(movieId)
     }
}