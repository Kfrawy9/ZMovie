package com.kfrawy.feature_movie_details.domain.usecase

import com.kfrawy.core.utils.Result
import com.kfrawy.feature_movie_details.domain.model.MovieDetail
import com.kfrawy.feature_movie_details.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(val repo: MovieDetailRepository) {
      operator fun invoke(movieId: Int): Flow<Result<MovieDetail>>{
         return repo.getMovieDetails(movieId)
     }
}