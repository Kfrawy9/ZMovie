package com.kfrawy.feature_movie_details.domain.usecase

import com.kfrawy.core.component.model.Review
import com.kfrawy.core.utils.Result
import com.kfrawy.feature_movie_details.domain.model.MovieDetail
import com.kfrawy.feature_movie_details.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetReviewsUseCase @Inject constructor(val repo: MovieDetailRepository) {
     suspend operator fun invoke(movieId: Int): Flow<Result<List<Review>>>{
         return repo.getMovieReviews(movieId)
     }
}