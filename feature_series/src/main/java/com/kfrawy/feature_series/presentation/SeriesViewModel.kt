package com.kfrawy.feature_series.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kfrawy.core.component.model.HorizontalData
import com.kfrawy.core.component.model.ViewState
import com.kfrawy.core.utils.ErrorTypes
import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Movie
import com.kfrawy.data.model.Series
import com.kfrawy.feature_series.domain.usecase.DeleteSeriesUseCase
import com.kfrawy.feature_series.domain.usecase.GetAiringTodayShow
import com.kfrawy.feature_series.domain.usecase.GetOnTheAirShow
import com.kfrawy.feature_series.domain.usecase.GetPopularShow
import com.kfrawy.feature_series.domain.usecase.GetTopRatedShow
import com.kfrawy.feature_series.domain.usecase.GetTrendingShow
import com.kfrawy.feature_series.domain.usecase.InsertSeriesUseCase
import com.kfrawy.feature_series.domain.usecase.SeriesUseCase
import com.kfrawy.feature_series.presentation.utlis.Mapper
import com.kfrawy.feature_series.presentation.utlis.SeriesIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val getAiringTodayShow: GetAiringTodayShow,
    private val getPopularShow: GetPopularShow,
    private val getOnTheAirShow: GetOnTheAirShow,
    private val getTrendingShow: GetTrendingShow,
    private val getTopRatedShow: GetTopRatedShow,
    private val insertSeriesUseCase: InsertSeriesUseCase,
    private val deleteSeriesUseCase: DeleteSeriesUseCase,
) : ViewModel() {

    private val _popularState: MutableState<ViewState<List<HorizontalData>>> =
        mutableStateOf(ViewState<List<HorizontalData>>(true, emptyList(), "", false))
    val popularState: State<ViewState<List<HorizontalData>>> = _popularState
    private val _trendingState: MutableState<ViewState<List<HorizontalData>>> =
        mutableStateOf(ViewState<List<HorizontalData>>(true, emptyList(), "", false))
    val trendingState: State<ViewState<List<HorizontalData>>> = _trendingState
    private val _topRatedState: MutableState<ViewState<List<HorizontalData>>> =
        mutableStateOf(ViewState<List<HorizontalData>>(true, emptyList(), "", false))
    val topRatedState: State<ViewState<List<HorizontalData>>> = _topRatedState
    private val _onTheAirState: MutableState<ViewState<List<HorizontalData>>> =
        mutableStateOf(ViewState<List<HorizontalData>>(true, emptyList(), "", false))
    val onTheAirState: State<ViewState<List<HorizontalData>>> = _onTheAirState
    private val _airingTodayState: MutableState<ViewState<List<HorizontalData>>> =
        mutableStateOf(ViewState<List<HorizontalData>>(true, emptyList(), "", false))
    val airingTodayState: State<ViewState<List<HorizontalData>>> = _airingTodayState


    fun handleIntent(seriesIntent: SeriesIntent){
        when(seriesIntent){
            SeriesIntent.loadSeries -> {
                getSeries()
            }
            is SeriesIntent.seriesClicked -> {

            }
            is SeriesIntent.showMore -> {

            }

            is SeriesIntent.DeleteSeriesDB -> {
                viewModelScope.launch {
                    deleteSeriesUseCase.invoke(seriesIntent.show)
                }
            }
            is SeriesIntent.InsertSeriesDB -> {
                viewModelScope.launch {
                    insertSeriesUseCase.invoke(seriesIntent.show)
                }
            }
        }
    }

    fun getSeries(){
        viewModelScope.launch {
            loadData(getTrendingShow, _trendingState)
            loadData(getPopularShow, _popularState)
            loadData(getAiringTodayShow, _airingTodayState)
            loadData(getTopRatedShow, _topRatedState)
            loadData(getOnTheAirShow, _onTheAirState)
        }
    }


    suspend fun loadData(useCase: SeriesUseCase,
                         mutableState: MutableState<ViewState<List<HorizontalData>>>){
        useCase.invoke().collect {
            when(it){

                is Result.Success<List<Series>> -> {
                    mutableState.value = mutableState.value.copy(false, Mapper.toHorizontalData(it.result), "")
                }

                is Result.Loading<*> -> {
                    mutableState.value =  mutableState.value.copy(true)
                }

                is Result.Error -> {
                    handleError(it.error, mutableState)
                }
            }
        }
    }

    fun handleError(error: ErrorTypes, mutableState: MutableState<ViewState<List<HorizontalData>>>){
        when(error){
            is ErrorTypes.ClientError -> {
                mutableState.value = mutableState.value.copy(false, error = error.message)
            }
            ErrorTypes.EmptyData -> {
                mutableState.value =  mutableState.value.copy(false, error = "Empty Data")
            }
            is ErrorTypes.ServerError -> {
                mutableState.value = mutableState.value.copy(false, error = error.message)
            }
        }
    }



}