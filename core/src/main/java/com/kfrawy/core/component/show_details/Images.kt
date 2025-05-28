package com.kfrawy.core.component.show_details

import android.graphics.Movie
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kfrawy.core.component.model.Image
import com.kfrawy.core.utils.MOVIE_IMAGE_URL

@Composable
fun Images(image: List<Image>) {

    LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
        items(image.size) {
            AsyncImage(
                model = "${MOVIE_IMAGE_URL}${image[it].file_path}",
                contentDescription = "Show Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(180.dp)
                    .height(200.dp)
            )
        }
    }


}