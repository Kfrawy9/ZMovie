package com.kfrawy.feature_series_details.presentation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kfrawy.core.component.EmptyDataView
import com.kfrawy.core.component.ErrorView
import com.kfrawy.core.component.HeadTitle
import com.kfrawy.core.component.HorizontalItem
import com.kfrawy.core.component.LoadingState
import com.kfrawy.core.component.Spacing
import com.kfrawy.core.component.show_details.Cast
import com.kfrawy.core.component.show_details.Images
import com.kfrawy.core.component.show_details.Reviews
import com.kfrawy.core.component.show_details.ShowInfo
import com.kfrawy.core.component.show_details.VideoItem
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SeriesDetails(seriesId: Int) {

    val viewmodel = hiltViewModel<SeriesDetailViewModel>()


    viewmodel.getSeriesIntent(SeriesDetailIntent.GetSeriesDetails(seriesId))
    val images = viewmodel.imageState.value
    val videos = viewmodel.videoState.value
    val reviews = viewmodel.reviewState.value
    val casts = viewmodel.creditsState.value
    val seriesDetail = viewmodel.seriesDetailState.value
    var season = seriesDetail.data.seasons
    val recommendations = viewmodel.recommendationState.value
    val similar = viewmodel.similarState.value

    LazyColumn(
        modifier = Modifier.padding(6.dp)
    ) {

        when {
            reviews.loading -> {
                item { LoadingState() }
            }

            reviews.error.isNotEmpty() -> {
                item { Text(reviews.error) }
            }

            else -> {
                when {

                    seriesDetail.loading->{}

                    seriesDetail.error.isNotEmpty() -> {}


                    else -> {
                        val details = seriesDetail.data
                        season = details.seasons
                        Log.d("CheckingYear", "SeriesDetails: ${details.first_air_date}")
                        Log.d("CheckingYear", "SeriesDetails: ${details.overview}")
                        Log.d("CheckingYear", "SeriesDetails: ${details.id}")
                        Log.d("CheckingYear", "SeriesDetails: ${details.name}")
                        Log.d("CheckingYear", "ID: $seriesId")
                        val year = 202
                            //if (details.first_air_date.isNotEmpty()) LocalDate.parse(details.first_air_date).year
                           // else 2020
                        item {
                            ShowInfo(
                                details.poster_path ?: details.backdrop_path ?: "",
                                details.original_name,
                                year,
                                details.seasons.size.toString(),
                                details.vote_average,
                                details.overview,
                            )
                        }
                        Spacing(12.dp)
                        if (season.isNotEmpty()) {
                            HeadTitle("Season")
                            Spacing(8.dp)
                            item {
                                LazyRow {
                                    items(season.size) {
                                        SeasonItem(season[it])
                                    }
                                    Spacing(12.dp)
                                }
                            }
                        }
                    }
                }



                HeadTitle("Images")
                Spacing(8.dp)
                when {
                    images.error.isNotEmpty() -> {
                        item { ErrorView(images.error) }
                    }

                    images.empty -> {
                        EmptyDataView("Images")
                    }

                    else -> {
                        item { Images(images.data) }
                    }
                }
                Spacing(12.dp)


                HeadTitle("Videos")
                Spacing(8.dp)
                when {
                    videos.error.isNotEmpty() -> {
                        item { ErrorView(videos.error) }
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
                when {
                    videos.error.isNotEmpty() -> {
                        item { ErrorView(images.error) }
                    }

                    casts.empty -> {
                        EmptyDataView("Casts")
                    }

                    else -> {
                        item {
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                items(casts.data.size) { Cast(casts.data[it]) }
                            }
                        }
                    }
                }

                Spacing(12.dp)
                HeadTitle("Similar")
                Spacing(8.dp)
                when {
                    similar.error.isNotEmpty() -> {
                        item { ErrorView(images.error) }
                    }

                    similar.empty -> {
                        EmptyDataView("Similar Series")
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
                when {
                    recommendations.error.isNotEmpty() -> {
                        item { ErrorView(images.error) }
                    }

                    recommendations.empty -> {
                        EmptyDataView("Recommendation Series")
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

                if (!reviews.empty) {
                    Spacing(12.dp)

                    HeadTitle("Reviews")
                    Spacing(8.dp)

                    items(Math.min(reviews.data.size, 3)) {
                        Reviews(reviews.data[it])
                    }
                }

                Spacing(6.dp)

            }

        }


    }

}