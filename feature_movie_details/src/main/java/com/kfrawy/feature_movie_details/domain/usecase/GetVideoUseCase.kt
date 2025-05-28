package com.kfrawy.feature_movie_details.domain.usecase

import com.kfrawy.core.component.model.Image
import com.kfrawy.core.component.model.Video
import com.kfrawy.core.utils.Result
import com.kfrawy.feature_movie_details.domain.model.MovieDetail
import com.kfrawy.feature_movie_details.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

class GetVideoUseCase @Inject constructor(val repo: MovieDetailRepository) {
      operator fun invoke(movieId: Int): Flow<Result<List<Video>>>{

          return repo.getMovieVideo(movieId)
     }
}