package com.kfrawy.feature_movie_details.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kfrawy.core.component.EmptyDataView
import com.kfrawy.core.component.ErrorView
import com.kfrawy.core.component.HeadTitle
import com.kfrawy.core.component.HorizontalItem
import com.kfrawy.core.component.LoadingState
import com.kfrawy.core.component.Spacing
import com.kfrawy.core.component.model.ViewState
import com.kfrawy.core.component.show_details.Cast
import com.kfrawy.core.component.show_details.Images
import com.kfrawy.core.component.show_details.Review
import com.kfrawy.core.component.show_details.Reviews
import com.kfrawy.core.component.show_details.ShowInfo
import com.kfrawy.core.component.show_details.VideoItem
import retrofit2.http.HEAD
import java.time.LocalDate

@Composable
fun MovieDetails(movieId: Int) {

    val viewModel: MovieDetailViewModel = hiltViewModel()
    viewModel.getMovieIntent(MovieDetailIntent.getMovieDetails(movieId))

    val movieDetail = viewModel.movieDetailState.value.data
    LazyColumn(
        modifier = Modifier.padding(6.dp)
    ) {
        val reviews = viewModel.reviewState.value
        when{
            reviews.loading -> {
                item{LoadingState()}
            }

            else -> {

                item {
                    ShowInfo(
                        movieDetail.poster_path ?: "",
                        movieDetail.original_title,
                        movieDetail.release_date.take(4).toInt(),
                        movieDetail.runtime.toString(),
                        movieDetail.vote_average,
                        movieDetail.overview
                    )
                }

                Spacing(12.dp)
                HeadTitle("Images")
                Spacing(8.dp)
                val images = viewModel.imageState.value
                when {
                    images.error.isNotEmpty() -> {
                        item { ErrorView(images.error) }
                    }

                    images.empty -> {
                        EmptyDataView("Images")
                    }

                    else -> {
                        item {
                            Images(images.data)
                        }
                    }
                }


                Spacing(12.dp)
                HeadTitle("Videos")
                val videos = viewModel.videoState.value
                when {
                    videos.error.isNotEmpty() -> {
                        item { ErrorView(images.error) }
                    }
                    videos.empty -> {
                        EmptyDataView("Videos")
                    }
                    else -> {
                        item { VideoItem(videos.data) { } }
                    }
                }

                Spacing(12.dp)
                HeadTitle("Casts")
                Spacing(8.dp)
                val casts = viewModel.creditsState.value
                when {
                    casts.error.isNotEmpty() -> {
                        item { ErrorView(images.error) }
                    }
                    casts.empty -> {
                        EmptyDataView("Casts")
                    }
                    else -> {
                        item {
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                items(casts.data.size) { Cast(casts.data[it]) }
                            }
                        }
                    }
                }

                Spacing(12.dp)
                HeadTitle("Similar")
                Spacing(8.dp)
                val similar = viewModel.similarState.value
                when {
                    similar.error.isNotEmpty() -> {
                        item { ErrorView(images.error) }
                    }

                    similar.empty -> {
                        EmptyDataView("Similar Movies")
                    }

                    else -> {
                        item {
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                items(similar.data.size) {
                                    HorizontalItem(
                                        similar.data[it],
                                        {},
                                        { a, b -> })
                                }
                            }
                        }
                    }
                }


                Spacing(12.dp)
                HeadTitle("Recommendation")
                Spacing(8.dp)
                val recommendations = viewModel.recommendationState.value
                when {
                    recommendations.error.isNotEmpty() -> {
                        item { ErrorView(images.error) }
                    }

                    recommendations.empty -> {
                        EmptyDataView("Recommendations Movies")
                    }

                    else -> {
                        item {
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                items(recommendations.data.size) {
                                    HorizontalItem(
                                        recommendations.data[it],
                                        {},
                                        { a, b -> })
                                }
                            }
                        }
                    }
                }
                Spacing(12.dp)
                HeadTitle("Reviews")
                Spacing(8.dp)

                when {
                    reviews.error.isNotEmpty() -> {
                        item { ErrorView(images.error) }
                    }
                    reviews.error.isNotEmpty() -> {
                        item { Text(reviews.error) }
                    }
                    else -> {
                        items(Math.min(reviews.data.size, 3)) {
                            Reviews(reviews.data[it])
                        }
                    }
                }
                Spacing(6.dp)
            }
        }


    }


}