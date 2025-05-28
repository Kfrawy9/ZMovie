package com.kfrawy.feature_series_details.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.kfrawy.core.R
import com.kfrawy.core.utils.Colors
import com.kfrawy.feature_series_details.domain.model.Season

@Composable
fun SeasonItem(season: Season){
    Card(shape = RoundedCornerShape(12.dp),
        modifier = Modifier.width(120.dp).wrapContentHeight()
            .background(Color.Transparent).padding(end = 8.dp).clickable { }) {
        Column(
        ) {

            AsyncImage(model = "https://image.tmdb.org/t/p/w500${season.poster_path}",
            contentDescription = "Season Image",
            contentScale = ContentScale.FillBounds,
                error = painterResource(R.drawable.no_pictures),
                fallback = painterResource(R.drawable.no_pictures),
            modifier = Modifier.fillMaxWidth().height(130.dp)
            )

            Text(
                "Season ${season.season_number}",
                fontWeight = FontWeight.Bold, fontSize = 14.sp,
                modifier = Modifier.padding(4.dp)
            )

        }
    }
}