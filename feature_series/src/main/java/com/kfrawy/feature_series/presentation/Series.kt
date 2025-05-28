package com.kfrawy.feature_series.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.kfrawy.core.component.ErrorView
import com.kfrawy.core.component.LoadingState
import com.kfrawy.feature_series.presentation.utlis.Mapper
import com.kfrawy.feature_series.presentation.utlis.SeriesIntent

@Composable
fun Series(onShowClicked: (showId: Int) -> Unit){

    val viewModel: SeriesViewModel = hiltViewModel()

    val state = viewModel.onTheAirState.value
    viewModel.handleIntent(SeriesIntent.loadSeries)

    when{
        state.loading -> {
            LoadingState()
        }
        state.error.isNotEmpty() -> {
            ErrorView(state.error)
        }
        else -> {
            SeriesView(
                viewModel.trendingState.value.data,
                viewModel.onTheAirState.value.data,
                viewModel.topRatedState.value.data,
                viewModel.popularState.value.data,
                viewModel.airingTodayState.value.data,
                onShowClicked,
                {data, bookmark ->
                    if (bookmark){
                        data.bookmarked = true
                        viewModel.handleIntent(SeriesIntent.InsertSeriesDB(Mapper.toShow(data)))
                    }
                    else{
                        data.bookmarked = false
                        viewModel.handleIntent(SeriesIntent.DeleteSeriesDB(Mapper.toShow(data)))
                    }
                }
            )
        }
    }


}