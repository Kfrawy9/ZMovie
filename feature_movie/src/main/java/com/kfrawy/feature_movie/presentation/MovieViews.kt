package com.kfrawy.feature_movie.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kfrawy.core.component.CarouselList
import com.kfrawy.core.component.HeadTitle
import com.kfrawy.core.component.HeadTitleNMore
import com.kfrawy.core.component.HorizontalListView
import com.kfrawy.core.component.Spacing
import com.kfrawy.core.component.model.HorizontalData

@Composable
fun MovieView(trending: List<HorizontalData>,
              nowPlaying: List<HorizontalData>,
              popular: List<HorizontalData>,
              topRated: List<HorizontalData>,
              upComing: List<HorizontalData>,
    onMovieClicked: (movieId: Int) -> Unit,
              onBookmarkClicked: (showId: HorizontalData, bookmark: Boolean) -> Unit) {
    LazyColumn(modifier = Modifier.padding(6.dp)) {

        HeadTitle("Trending")
        Spacing(8.dp)
        item { CarouselList(trending, onMovieClicked) }
        Spacing(12.dp)

        HeadTitleNMore("Now Playing") { }
        Spacing(8.dp)
        item {
            HorizontalListView(nowPlaying, "Movies", onMovieClicked, onBookmarkClicked)
        }
        Spacing(12.dp)

        HeadTitleNMore("Popular") { }
        Spacing(8.dp)
        item { HorizontalListView(popular, "Movies", onMovieClicked, onBookmarkClicked) }
        Spacing(12.dp)

        HeadTitleNMore("Top Rated") { }
        Spacing(8.dp)
        item { HorizontalListView(topRated, "Movies", onMovieClicked, onBookmarkClicked) }
        Spacing(12.dp)

        HeadTitleNMore("Up Coming") { }
        Spacing(8.dp)
        item { HorizontalListView(upComing, "Movies", onMovieClicked, onBookmarkClicked) }
        Spacing(12.dp)

    }
}