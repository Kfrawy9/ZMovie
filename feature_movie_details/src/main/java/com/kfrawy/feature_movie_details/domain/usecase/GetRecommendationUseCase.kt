package com.kfrawy.feature_movie_details.domain.usecase

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.kfrawy.core.component.model.HorizontalData
import com.kfrawy.core.component.model.ViewState
import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import com.kfrawy.feature_movie_details.domain.model.MovieDetail
import com.kfrawy.feature_movie_details.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

class GetRecommendationUseCase @Inject constructor(val repo: MovieDetailRepository) {
     suspend operator fun invoke(movieId: Int): Flow<Result<List<Movie>>>{
         return repo.getMovieRecommendation(movieId)
     }
}