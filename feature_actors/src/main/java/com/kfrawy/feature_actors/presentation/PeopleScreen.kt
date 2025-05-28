package com.kfrawy.feature_actors.presentation

import android.util.Log
import android.widget.SearchView
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.kfrawy.core.component.LoadingState
import com.kfrawy.feature_actors.domain.model.People
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun PeopleScreen(onSearchClicked: () -> Unit) {

    val viewModel = hiltViewModel<PeopleViewModel>()
    viewModel.loadIntent(PeopleIntent.GetTrendingPeople)
    val people = viewModel.data.collectAsLazyPagingItems()

    LazyVerticalGrid(
        modifier = Modifier.padding(6.dp),
        columns = GridCells.Fixed(4),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        if (people.loadState.refresh is LoadState.Loading)
            item { LoadingState() }

        items(people.itemCount) {
            PeopleItem(people[it])
        }

    }


}
