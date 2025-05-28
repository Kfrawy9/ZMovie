package com.kfrawy.feature_movie.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kfrawy.core.component.model.HorizontalData
import com.kfrawy.core.component.model.ViewState
import com.kfrawy.core.utils.ErrorTypes
import com.kfrawy.core.utils.Result
import com.kfrawy.core.utils.UIState
import com.kfrawy.core.utils.UIState.*
import com.kfrawy.data.model.Movie
import com.kfrawy.feature_movie.domain.usecase.DeleteMovieUseCase
import com.kfrawy.feature_movie.domain.usecase.GetNowPlayingUseCase
import com.kfrawy.feature_movie.domain.usecase.GetPopularUseCase
import com.kfrawy.feature_movie.domain.usecase.GetTopRatedUseCase
import com.kfrawy.feature_movie.domain.usecase.GetTrendingUseCase
import com.kfrawy.feature_movie.domain.usecase.GetUpComingUseCase
import com.kfrawy.feature_movie.domain.usecase.InsertMovieUseCase
import com.kfrawy.feature_movie.domain.usecase.MovieUseCase
import com.kfrawy.feature_movie.utils.Mapper
import com.kfrawy.feature_movie.utils.MovieIntent
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getPopularUseCase: GetPopularUseCase,
    private val getTrendingUseCase: GetTrendingUseCase,
    private val getUpComingUseCase: GetUpComingUseCase,
    private val getTopRatedUseCase: GetTopRatedUseCase,
    private val getNowPlayingUseCase: GetNowPlayingUseCase,
    private val deleteMovieUseCase: DeleteMovieUseCase,
    private val insertMovieUseCase: InsertMovieUseCase,
): ViewModel() {

    private val _popularState: MutableState<ViewState<List<HorizontalData>>> =
        mutableStateOf(ViewState<List<HorizontalData>>(true, emptyList(), "", false))
    val popularState: State<ViewState<List<HorizontalData>>> = _popularState
    private val _trendingState: MutableState<ViewState<List<HorizontalData>>>
    = mutableStateOf(ViewState<List<HorizontalData>>(true, emptyList(), "", false))
    val trendingState: State<ViewState<List<HorizontalData>>> = _trendingState
    private val _topRatedState: MutableState<ViewState<List<HorizontalData>>>
    = mutableStateOf(ViewState<List<HorizontalData>>(true, emptyList(), "", false))
    val topRatedState: State<ViewState<List<HorizontalData>>> = _topRatedState
    private val _nowPlayingState: MutableState<ViewState<List<HorizontalData>>>
    = mutableStateOf(ViewState<List<HorizontalData>>(true, emptyList(), "", false))
    val nowPlayingState: State<ViewState<List<HorizontalData>>> = _nowPlayingState
    private val _upComingState: MutableState<ViewState<List<HorizontalData>>>
    = mutableStateOf(ViewState<List<HorizontalData>>(true, emptyList(), "", false))
    val upComingState: State<ViewState<List<HorizontalData>>> = _upComingState


    fun handleIntent(movieIntent: MovieIntent){
        when(movieIntent){
            MovieIntent.GetMovies -> {
                getMovies()
            }
            is MovieIntent.MovieClickedEvent -> {

            }
            is MovieIntent.SeeMoreEvent -> {

            }

            is MovieIntent.DeleteMovieDB -> {
                viewModelScope.launch {
                    deleteMovieUseCase.invoke(movieIntent.show)
                }
            }
            is MovieIntent.InsertMovieDB -> {
                viewModelScope.launch {
                    insertMovieUseCase.invoke(movieIntent.show)
                }
            }
        }
    }

    fun getMovies(){
        viewModelScope.launch {
            loadData(getPopularUseCase, _popularState)
            loadData(getTrendingUseCase, _trendingState)
            loadData(getUpComingUseCase, _upComingState)
            loadData(getNowPlayingUseCase, _nowPlayingState)
            loadData(getTopRatedUseCase, _topRatedState)
        }
    }


    suspend fun loadData(useCase: MovieUseCase,
                         mutableState: MutableState<ViewState<List<HorizontalData>>>){
        useCase.invoke().collect {
            when(it){

                is Result.Success<List<Movie>> -> {
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