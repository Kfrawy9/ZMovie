package com.kfrawy.feature_watchlist.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kfrawy.core.component.HorizontalItem
import com.kfrawy.core.component.model.HorizontalData
import com.kfrawy.data.model.Show

@Composable
fun WatchList(onItemClicked: (Int) -> Unit){
    val viewModel: BookMarkViewModel = hiltViewModel()
    viewModel.loadIntent(WatchListIntent.LoadWatchList)
    WatchListView(viewModel.watchList.value, onItemClicked, {data, bookmark->
        if (!bookmark)
            viewModel.loadIntent(WatchListIntent.DeleteShow(Show(
                data.id,
                data.title,
                data.url,
                data.rating,
                data.year,
                data.bookmarked,
            )))
    })

}


@Composable
fun WatchListView(items: List<HorizontalData>,
                  onItemClicked: (itemId: Int) -> Unit,
                  onBookmarkClicked: (itemId: HorizontalData, bookmark: Boolean) -> Unit){

    LazyVerticalGrid(modifier = Modifier.padding(8.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(6.dp),
         horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        items(items.size) {
            HorizontalItem(items[it], onItemClicked, onBookmarkClicked)
        }

    }


}