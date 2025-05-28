package com.kfrawy.core.component.show_details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.kfrawy.core.R
import com.kfrawy.core.component.model.Review
import com.kfrawy.core.utils.Colors.Blue900
import org.intellij.lang.annotations.JdkConstants

@Composable
fun Reviews(review: Review){

    Column(
        modifier = Modifier.padding(6.dp)
            .background(Color.Transparent)
            .fillMaxWidth()
            .wrapContentHeight()
    ){

        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${review.author_details.avatar_path}",
                contentDescription = "User Image",
                contentScale = ContentScale.Crop,
                fallback = painterResource(R.drawable.user),
                error = painterResource(R.drawable.user),
                modifier = Modifier
                    .size(70.dp)
                    .padding(end = 6.dp)
                    .clip(CircleShape),
            )

            Column(modifier = Modifier.padding(end = 6.dp).weight(0.5f)) {
                Text(
                    text = review.author,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp, modifier = Modifier.padding(bottom = 4.dp).wrapContentSize()
                )
                Text(text = review.created_at,
                    fontSize = 12.sp,
                    color = Blue900, modifier = Modifier.wrapContentSize())
            }

            OutlinedCard(
                border = BorderStroke(1.dp, Color.LightGray),
                modifier = Modifier
            ) {
                Row(modifier = Modifier.padding(6.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star, contentDescription = "Star",
                        tint = Color.Yellow,
                        modifier = Modifier
                            .size(14.dp)
                            .padding(end = 2.dp)
                    )
                    Text(text = "${review.author_details.rating ?: 0}", fontSize = 12.sp, color = Color.Black)
                }
            }
        }

        Text(
            text = review.content,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight().padding(top = 6.dp),
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,

            )
    }
}