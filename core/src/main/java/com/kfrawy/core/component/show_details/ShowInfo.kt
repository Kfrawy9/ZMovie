package com.kfrawy.core.component.show_details

import android.accessibilityservice.GestureDescription
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.kfrawy.core.R
import com.kfrawy.core.utils.MOVIE_IMAGE_URL
import java.time.Year

@Composable
fun ShowInfo(
    url: String,
    title: String,
    year: Int,
    duration: String,
    vote: Double,
    description: String,
) {

    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp),

    ) {
        Box {
            AsyncImage(
                model = "${MOVIE_IMAGE_URL}$url",
                contentDescription = "Movie Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                fallback = painterResource(R.drawable.no_pictures),
                error = painterResource(R.drawable.no_pictures),
                contentScale = ContentScale.Crop
            )
            IconButton({ }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(8.dp)
                )
            }

            Icon(
                imageVector = Icons.Default.Star, contentDescription = "Star",
                tint = Color.Yellow,
                modifier = Modifier
                    .size(14.dp)
                    .align(Alignment.TopEnd)
                    .padding(6.dp)
            )

        }

        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(280.dp)
                .align(Alignment.CenterHorizontally)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ){
            Text(
                text = "$year",
                fontSize = 14.sp,
                color = Color.Black,
            )

            Text(
                text = duration,
                fontSize = 14.sp,
                color = Color.Black,
            )

            Icon(
                painter = painterResource(R.drawable.baseline_star),
                contentDescription = "Star",
                tint = Color.Yellow,
                modifier = Modifier.size(20.dp)
            )

            Text(
                text = "$vote",
                fontSize = 14.sp,
                color = Color.Black,
            )

        }

        Text(
            text = description,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier.wrapContentSize()
        )

    }

}

