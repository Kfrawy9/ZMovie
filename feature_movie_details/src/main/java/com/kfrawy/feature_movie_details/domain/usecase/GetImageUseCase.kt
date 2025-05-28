package com.kfrawy.feature_movie_details.domain.usecase

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.kfrawy.core.component.model.Image
import com.kfrawy.core.component.model.ViewState
import com.kfrawy.core.utils.Result
import com.kfrawy.feature_movie_details.domain.model.MovieDetail
import com.kfrawy.feature_movie_details.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetImageUseCase @Inject constructor(val repo: MovieDetailRepository) {
     suspend operator fun invoke(movieId: Int): Flow<Result<List<Image>>>{
         return repo.getMovieImages(movieId)
     }
}