package com.kfrawy.core.component

import android.icu.number.Scale
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kfrawy.core.R
import com.kfrawy.core.component.model.HorizontalData
import com.kfrawy.core.utils.MOVIE_IMAGE_URL
import kotlinx.coroutines.delay

@Composable
fun CarouselList(items: List<HorizontalData>,
                 onItemClicked: (itemId: Int) -> Unit){
    val pagerState = rememberPagerState{items.take(10).size}

    Column(modifier = Modifier.padding(8.dp), ) {

        HorizontalPager(pagerState,
            beyondViewportPageCount = 5,
            pageSize = PageSize.Fill,
            pageSpacing = 8.dp,) {
            AsyncImage(
                model = "$MOVIE_IMAGE_URL${items[it].url}",
                contentDescription = "Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(4.dp)).clickable{onItemClicked(items[it].id)}
                )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp),
            horizontalArrangement = Arrangement.Center
            ,
            verticalAlignment = Alignment.CenterVertically,
        ){
            repeat(pagerState.pageCount){
                val color = if (pagerState.currentPage == it) Color.DarkGray else Color.Gray
                Box(
                    modifier = Modifier.padding(end = 4.dp ).size(12.dp)
                        .clip(CircleShape)
                        .background(color)

                )
            }
        }
    }

    LaunchedEffect(pagerState) {
        while (true){
            delay(2000L)
            val page = (pagerState.currentPage + 1) % 10
            pagerState.animateScrollToPage(page)
        }
    }


}