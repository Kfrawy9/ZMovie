package com.kfrawy.feature_series.presentation

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
fun SeriesView(trendingShow: List<HorizontalData>,
           onTheAirShow: List<HorizontalData>,
           topRatedShow: List<HorizontalData>,
           popularShow: List<HorizontalData>,
           airingTodayShow: List<HorizontalData>,
           onShowClicked: (showId: Int) -> Unit,
               onBookmarkClicked: (showId: HorizontalData, bookmark: Boolean) -> Unit){

    LazyColumn(
        modifier = Modifier.padding(6.dp)
    ) {

        HeadTitle("Trending")
        Spacing(8.dp)
        item { CarouselList(trendingShow, onShowClicked)}
        Spacing(12.dp)

        HeadTitleNMore("On The Air") {  }
        Spacing(8.dp)
        item { HorizontalListView(onTheAirShow, "Show", onShowClicked, onBookmarkClicked) }
        Spacing(12.dp)

        HeadTitleNMore("Top Rated") {  }
        Spacing(8.dp)
        item{ HorizontalListView(topRatedShow, "Show", onShowClicked, onBookmarkClicked) }
        Spacing(12.dp)

        HeadTitleNMore("Popular") {  }
        Spacing(8.dp)
        item { HorizontalListView(popularShow, "Show", onShowClicked, onBookmarkClicked) }
        Spacing(12.dp)

        HeadTitleNMore("Airing Today") {  }
        Spacing(8.dp)
        item { HorizontalListView(airingTodayShow, "Show", onShowClicked, onBookmarkClicked) }
        Spacing(12.dp)

    }

}