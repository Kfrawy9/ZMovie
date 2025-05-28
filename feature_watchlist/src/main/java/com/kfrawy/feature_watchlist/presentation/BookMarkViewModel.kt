package com.kfrawy.feature_watchlist.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kfrawy.core.component.model.HorizontalData
import com.kfrawy.feature_watchlist.domain.usecase.DeleteMovieUseCase
import com.kfrawy.feature_watchlist.domain.usecase.GetWatchListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val getWatchList: GetWatchListUseCase,
    private val deleteMovieUseCase: DeleteMovieUseCase
) : ViewModel() {

    private val _watchList: MutableState<List<HorizontalData>> = mutableStateOf(emptyList())
    val watchList: State<List<HorizontalData>> = _watchList

    fun loadIntent(watchListIntent: WatchListIntent) {
        when (watchListIntent) {
            is WatchListIntent.DeleteShow -> {
                viewModelScope.launch {
                    deleteMovieUseCase.invoke(watchListIntent.show)
                }
            }

            WatchListIntent.LoadWatchList -> {
                viewModelScope.launch {
                    getWatchList.invoke().collectLatest {
                        val data: MutableList<HorizontalData> = mutableListOf()
                        it.forEach {
                            data.add(HorizontalData(it.id, it.title, it.poster_path?:"",
                                it.popularity, it.year, it.bookmarked))
                        }
                        _watchList.value = data
                    }
                }
            }
        }
    }

}