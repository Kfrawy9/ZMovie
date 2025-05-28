package com.kfrawy.feature_movie.presentation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kfrawy.core.component.ErrorView
import com.kfrawy.core.component.LoadingState
import com.kfrawy.core.component.model.HorizontalData
import com.kfrawy.core.utils.Colors
import com.kfrawy.feature_movie.utils.Mapper
import com.kfrawy.feature_movie.utils.MovieIntent

@Composable
fun Movie(onMovieClicked: (itemId: Int) -> Unit,) {

    val viewModel: MovieViewModel = hiltViewModel<MovieViewModel>()

    val popularState = viewModel.popularState.value
    val trendingState = viewModel.trendingState.value
    val upComingState = viewModel.upComingState.value
    val topRatedState = viewModel.topRatedState.value
    val nowPlayingState = viewModel.nowPlayingState.value
    viewModel.handleIntent(MovieIntent.GetMovies)
    when  {
        topRatedState.loading -> { LoadingState() }
        topRatedState.error.isNotEmpty() -> { ErrorView(topRatedState.error) }
        else ->{

            MovieView(
                trendingState.data,
                nowPlayingState.data,
                popularState.data,
                topRatedState.data,
                upComingState.data,
                onMovieClicked,
                { data: HorizontalData, bookmark: Boolean ->
                    if (bookmark){
                        data.bookmarked = true
                        viewModel.handleIntent(MovieIntent.InsertMovieDB(Mapper.toShow(data)))
                    }
                    else{
                        data.bookmarked = false
                        viewModel.handleIntent(MovieIntent.DeleteMovieDB(Mapper.toShow(data)))
                    }
                })
        }
    }

}


