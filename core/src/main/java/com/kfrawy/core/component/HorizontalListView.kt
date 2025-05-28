package com.kfrawy.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.kfrawy.core.component.model.HorizontalData

@Composable
fun HorizontalListView(items: List<HorizontalData>,
                       type: String,
                       onItemClicked: (itemId: Int) -> Unit,
                       onBookmarkClicked: (itemId: HorizontalData, bookmark: Boolean) -> Unit){

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        if (items.isEmpty())
            EmptyDataView(type)
        else {
            items(items.size) {
                val item = items[it]
                HorizontalItem(item, onItemClicked, onBookmarkClicked)
            }
        }
    }

}

