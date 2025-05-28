package com.kfrawy.core.component.show_details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.kfrawy.core.R
import com.kfrawy.core.component.model.Cast
import com.kfrawy.core.utils.MOVIE_IMAGE_URL

@Composable
fun Cast(cast: Cast) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .wrapContentHeight()
            .background(Color.Transparent)
            .clickable { },

    ) {
        AsyncImage(
            model = "$MOVIE_IMAGE_URL${cast.profile_path}",
            contentDescription = "Cast Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            fallback = painterResource(R.drawable.user),
            error = painterResource(R.drawable.user)
        )


        Text(
            cast.name, fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            cast.character, fontSize = 10.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

    }


}

@Preview(showSystemUi = true)
@Composable
fun Review() {
}

