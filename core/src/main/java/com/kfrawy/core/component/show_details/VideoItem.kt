package com.kfrawy.core.component.show_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kfrawy.core.R
import com.kfrawy.core.component.model.Video

@Composable
fun VideoItem(video: List<Video>,
              onVideoClicked:(videoKey: String) -> Unit){

    LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
        items(video.size){
            ElevatedCard(modifier = Modifier.width(150.dp).
            height(100.dp).clip(RoundedCornerShape(6.dp))
                , onClick = { onVideoClicked(video[it].key) }) {
                Box{

                    AsyncImage(
                        model = "https://img.youtube.com/vi/${video[it].key}/maxresdefault.jpg",
                        contentDescription = "Youtube Image",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        error = painterResource(R.drawable.no_thumbnail)
                    )

                    Icon(
                        painter = painterResource(R.drawable.youtube_logo),
                        tint = Color.Red,
                        contentDescription = "Youtube Logo",
                        modifier = Modifier.size(50.dp).align(Alignment.Center)
                    )

                }
            }
        }
    }


}