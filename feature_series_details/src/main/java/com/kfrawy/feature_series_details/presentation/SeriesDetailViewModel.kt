package com.kfrawy.feature_series_details.presentation

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
import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Series
import com.kfrawy.feature_series_details.domain.model.SeriesDetail
import com.kfrawy.feature_series_details.domain.usecase.GetCreditsUseCase
import com.kfrawy.feature_series_details.domain.usecase.GetImageUseCase
import com.kfrawy.feature_series_details.domain.usecase.GetRecommendationUseCase
import com.kfrawy.feature_series_details.domain.usecase.GetReviewsUseCase
import com.kfrawy.feature_series_details.domain.usecase.GetSeriesDetailUseCase
import com.kfrawy.feature_series_details.domain.usecase.GetSimilarUseCase
import com.kfrawy.feature_series_details.domain.usecase.GetVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class SeriesDetailViewModel @Inject constructor(
    private val getVideoUseCase: GetVideoUseCase,
    private val getImageUseCase: GetImageUseCase,
    private val getReviewsUseCase: GetReviewsUseCase,
    private val getSeriesDetailUseCase: GetSeriesDetailUseCase,
    private val getCreditsUseCase: GetCreditsUseCase,
    private val getRecommendationUseCase: GetRecommendationUseCase,
    private val getSimilarUseCase: GetSimilarUseCase,
) : ViewModel() {

    private val _seriesDetailState: MutableState<ViewState<SeriesDetail>>
            = mutableStateOf(ViewState<SeriesDetail>(true, SeriesDetail(), "", false))
    val seriesDetailState: State<ViewState<SeriesDetail>> = _seriesDetailState

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


    fun getSeriesIntent(intent: SeriesDetailIntent){
        when(intent){
            is SeriesDetailIntent.GetSeriesDetails ->{
                viewModelScope.launch {
                    loadImage(intent.seriesId)
                    loadSeriesDetails(intent.seriesId)
                    loadVideo(intent.seriesId)
                    loadCast(intent.seriesId)
                    loadSimilar(intent.seriesId)
                    loadRecommendation(intent.seriesId)
                    loadReview(intent.seriesId)
                }
            }
            is SeriesDetailIntent.MovieClicked -> {}
        }
    }



    suspend fun loadSeriesDetails(seriesId: Int){
        getSeriesDetailUseCase.invoke(seriesId).collect {
            when(it){
                is Result.Error -> {
                    _seriesDetailState.value = _seriesDetailState.value.copy(loading = false, error = "")
                }
                is Result.Loading<*> -> {
                    _seriesDetailState.value = _seriesDetailState.value.copy(loading = true)
                }
                is Result.Success<SeriesDetail> -> {
                    _seriesDetailState.value = _seriesDetailState.value.copy(loading = false, it.result)
                }
            }
        }
    }



    suspend fun loadRecommendation(seriesId: Int){
        getRecommendationUseCase.invoke(seriesId).collect {
            when(it){
                is Result.Error -> {
                    _recommendationState.value = _recommendationState.value.copy(loading = false, error = "")
                }
                is Result.Loading<*> -> {
                    _recommendationState.value = _recommendationState.value.copy(loading = true)
                }
                is Result.Success<List<Series>> -> {
                    if (it.result.isEmpty())
                        _recommendationState.value = _recommendationState.value.copy(loading = false, empty = true)
                    else{
                        val result = it.result.map {
                            val year = if (it.first_air_date.isNotEmpty()) LocalDate.parse(it.first_air_date).year
                            else 2020
                            HorizontalData(it.id, it.name, it.poster_path ?: "",
                                it.vote_average, year)
                        }
                        _recommendationState.value = _recommendationState.value.copy(loading = false, result)
                    }
                }
            }
        }
    }

    suspend fun loadSimilar(seriesId: Int){
        getSimilarUseCase.invoke(seriesId).collect {
            when(it){
                is Result.Error -> {
                    _similarState.value = _similarState.value.copy(loading = false, error = "")
                }
                is Result.Loading<*> -> {
                    _similarState.value = _similarState.value.copy(loading = true)
                }
                is Result.Success<List<Series>> -> {
                    if (it.result.isEmpty())
                        _similarState.value = _similarState.value.copy(loading = false, empty = true)
                    else{
                        val result = it.result.map {
                            val year = if (it.first_air_date.isNotEmpty()) LocalDate.parse(it.first_air_date).year
                            else 2020
                            HorizontalData(it.id, it.name, it.poster_path ?: "",
                                it.vote_average, year)
                        }
                        _similarState.value = _similarState.value.copy(loading = false, result)
                    }

                }
            }
        }
    }

    suspend fun loadImage(seriesId: Int){
        getImageUseCase.invoke(seriesId).collect {
            when(it){
                is Result.Error -> {
                    _imagesState.value = _imagesState.value.copy(loading = false, error = "")
                }
                is Result.Loading<*> -> {
                    _imagesState.value = _imagesState.value.copy(loading = true)
                }
                is Result.Success<List<Image>> -> {
                    if (it.result.isEmpty())
                        _imagesState.value = _imagesState.value.copy(loading = false, empty = true)
                    else
                        _imagesState.value = _imagesState.value.copy(loading = false, it.result)
                }
            }
        }
    }
    suspend fun loadVideo(seriesId: Int){
        getVideoUseCase.invoke(seriesId).collect {
            when(it){
                is Result.Error -> {
                    _videosState.value = _videosState.value.copy(loading = false, error = "")
                }
                is Result.Loading<*> -> {
                    _videosState.value = _videosState.value.copy(loading = true)
                }
                is Result.Success<List<Video>> -> {
                    if (it.result.isEmpty())
                        _videosState.value = _videosState.value.copy(loading = false, empty = true)
                    else
                        _videosState.value = _videosState.value.copy(loading = false, it.result)
                }
            }
        }
    }

    suspend fun loadReview(seriesId: Int){
        getReviewsUseCase.invoke(seriesId).collect {
            when(it){
                is Result.Error -> {
                    _reviewsState.value = _reviewsState.value.copy(loading = false, error = "")
                }
                is Result.Loading<*> -> {
                    _reviewsState.value = _reviewsState.value.copy(loading = true)
                }
                is Result.Success<List<Review>> -> {
                    if (it.result.isEmpty())
                        _reviewsState.value = _reviewsState.value.copy(loading = false, empty = true)
                    else
                        _reviewsState.value = _reviewsState.value.copy(loading = false, it.result)
                }
            }
        }
    }

    suspend fun loadCast(seriesId: Int){
        getCreditsUseCase.invoke(seriesId).collect {
            when(it){
                is Result.Error -> {
                    _creditsState.value = _creditsState.value.copy(loading = false, error = "")
                }
                is Result.Loading<*> -> {
                    _creditsState.value = _creditsState.value.copy(loading = true)
                }
                is Result.Success<List<Cast>> -> {
                    if (it.result.isEmpty())
                        _creditsState.value = _creditsState.value.copy(loading = false, empty = true)
                    else
                        _creditsState.value = _creditsState.value.copy(loading = false, it.result)
                }
            }
        }
    }


}