package com.kfrawy.feature_movie_details.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kfrawy.core.component.model.Cast
import com.kfrawy.core.component.model.HorizontalData
import com.kfrawy.core.component.model.Image
import com.kfrawy.core.component.model.Review
import com.kfrawy.core.component.model.Video
import com.kfrawy.core.component.model.ViewState
import com.kfrawy.core.utils.ErrorTypes
import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import com.kfrawy.feature_movie_details.domain.model.MovieDetail
import com.kfrawy.feature_movie_details.domain.usecase.GetCreditsUseCase
import com.kfrawy.feature_movie_details.domain.usecase.GetImageUseCase
import com.kfrawy.feature_movie_details.domain.usecase.GetMovieDetailUseCase
import com.kfrawy.feature_movie_details.domain.usecase.GetRecommendationUseCase
import com.kfrawy.feature_movie_details.domain.usecase.GetReviewsUseCase
import com.kfrawy.feature_movie_details.domain.usecase.GetSimilarUseCase
import com.kfrawy.feature_movie_details.domain.usecase.GetVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch
import java.time.LocalDate
@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val getCreditsUseCase: GetCreditsUseCase,
    private val getReviewsUseCase: GetReviewsUseCase,
    private val getImageUseCase: GetImageUseCase,
    private val getVideoUseCase: GetVideoUseCase,
    private val getRecommendationUseCase: GetRecommendationUseCase,
    private val getSimilarUseCase: GetSimilarUseCase
): ViewModel() {


    private val _movieDetailState: MutableState<ViewState<MovieDetail>>
    = mutableStateOf(ViewState<MovieDetail>(true, MovieDetail(), "", false))
    val movieDetailState: State<ViewState<MovieDetail>> = _movieDetailState

    private val _imagesState: MutableState<ViewState<List<Image>>>
    = mutableStateOf(ViewState<List<Image>>(true, emptyList(), "", false))
    var imageState: State<ViewState<List<Image>>> = _imagesState

    private val _videosState: MutableState<ViewState<List<Video>>>
    = mutableStateOf(ViewState<List<Video>>(true, emptyList(), "", false))
    val videoState: State<ViewState<List<Video>>> = _videosState

    private val _reviewsState: MutableState<ViewState<List<Review>>>
    = mutableStateOf(ViewState<List<Review>>(true, emptyList(), "", false))
    val reviewState: State<ViewState<List<Review>>> = _reviewsState

    private val _creditsState: MutableState<ViewState<List<Cast>>>
    = mutableStateOf(ViewState<List<Cast>>(true, emptyList(), "", false))
    val creditsState: State<ViewState<List<Cast>>> = _creditsState

    private val _recommendationState: MutableState<ViewState<List<HorizontalData>>>
    = mutableStateOf(ViewState<List<HorizontalData>>(true, emptyList(), "", false))
    val recommendationState: State<ViewState<List<HorizontalData>>> = _recommendationState

    private val _similarState: MutableState<ViewState<List<HorizontalData>>>
    = mutableStateOf(ViewState<List<HorizontalData>>(true, emptyList(), "", false))
    val similarState: State<ViewState<List<HorizontalData>>> = _similarState


    fun getMovieIntent(movieDetailIntent: MovieDetailIntent) {
        when(movieDetailIntent){
            is MovieDetailIntent.MovieClicked -> {

            }
            is MovieDetailIntent.getMovieDetails -> {
                viewModelScope.launch {
                    loadMovieDetails(movieDetailIntent.movieId)
                    loadSimilar(movieDetailIntent.movieId)
                    loadImage(movieDetailIntent.movieId)
                    loadVideo(movieDetailIntent.movieId)
                    loadRecommendation(movieDetailIntent.movieId)
                    loadCast(movieDetailIntent.movieId)
                    loadReview(movieDetailIntent.movieId)
                }
            }
        }

    }


    suspend fun loadMovieDetails(movieId: Int){
        getMovieDetailUseCase.invoke(movieId).collect {
            when(it){
                is Result.Error -> {
                    _movieDetailState.value = _movieDetailState.value.copy(loading = false, error = "")
                }
                is Result.Loading<*> -> {
                    _movieDetailState.value = _movieDetailState.value.copy(loading = true)
                }
                is Result.Success<MovieDetail> -> {
                    _movieDetailState.value = _movieDetailState.value.copy(loading = false, it.result)
                }
            }
        }
    }



    suspend fun loadRecommendation(movieId: Int){
        getRecommendationUseCase.invoke(movieId).collect {
            when(it){
                is Result.Error -> {
                    _recommendationState.value = _recommendationState.value.copy(loading = false, error = "")
                }
                is Result.Loading<*> -> {
                    _recommendationState.value = _recommendationState.value.copy(loading = true)
                }
                is Result.Success<List<Movie>> -> {
                    val result = it.result.map {
                        val year = if (it.release_date.isNotEmpty()) LocalDate.parse(it.release_date).year
                        else 2020
                        HorizontalData(it.id, it.title, it.poster_path ?: "",
                            it.vote_average, year, )
                    }
                    _recommendationState.value = _recommendationState.value.copy(loading = false, result)
                }
            }
        }
    }

    suspend fun loadSimilar(movieId: Int){
        getSimilarUseCase.invoke(movieId).collect {
            when(it){
                is Result.Error -> {
                    _similarState.value = _similarState.value.copy(loading = false, error = "")
                }
                is Result.Loading<*> -> {
                    _similarState.value = _similarState.value.copy(loading = true)
                }
                is Result.Success<List<Movie>> -> {

                    val result = it.result.map {
                        val year = if (it.release_date.isNotEmpty()) LocalDate.parse(it.release_date).year
                        else 2020
                        HorizontalData(it.id, it.title, it.poster_path ?: "",
                            it.vote_average, year)
                    }
                    _similarState.value = _similarState.value.copy(loading = false, result)
                }
            }
        }
    }

    suspend fun loadImage(movieId: Int){
        getImageUseCase.invoke(movieId).collect {
            when(it){
                is Result.Error -> {
                    _imagesState.value = _imagesState.value.copy(loading = false, error = "")
                }
                is Result.Loading<*> -> {
                    _imagesState.value = _imagesState.value.copy(loading = true)
                }
                is Result.Success<List<Image>> -> {
                    _imagesState.value = _imagesState.value.copy(loading = false, it.result)
                }
            }
        }
    }
    suspend fun loadVideo(movieId: Int){
        getVideoUseCase.invoke(movieId).collect {
            when(it){
                is Result.Error -> {
                    _videosState.value = _videosState.value.copy(loading = false, error = "")
                }
                is Result.Loading<*> -> {
                    _videosState.value = _videosState.value.copy(loading = true)
                }
                is Result.Success<List<Video>> -> {
                    _videosState.value = _videosState.value.copy(loading = false, it.result)
                }
            }
        }
    }

    suspend fun loadReview(movieId: Int){
        getReviewsUseCase.invoke(movieId).collect {
            when(it){
                is Result.Error -> {
                    _reviewsState.value = _reviewsState.value.copy(loading = false, error = "")
                }
                is Result.Loading<*> -> {
                    _reviewsState.value = _reviewsState.value.copy(loading = true)
                }
                is Result.Success<List<Review>> -> {
                    _reviewsState.value = _reviewsState.value.copy(loading = false, it.result)
                }
            }
        }
    }

    suspend fun loadCast(movieId: Int){
        getCreditsUseCase.invoke(movieId).collect {
            when(it){
                is Result.Error -> {
                    _creditsState.value = _creditsState.value.copy(loading = false, error = "")
                }
                is Result.Loading<*> -> {
                    _creditsState.value = _creditsState.value.copy(loading = true)
                }
                is Result.Success<List<Cast>> -> {
                    _creditsState.value = _creditsState.value.copy(loading = false, it.result)
                }
            }
        }
    }






}