package com.kfrawy.feature_actors.presentation

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.kfrawy.core.utils.Colors.Blue900
import com.kfrawy.core.utils.MOVIE_IMAGE_URL
import com.kfrawy.feature_actors.domain.model.People

@Composable
fun PeopleItem(person: People?){

    OutlinedCard(
        border = BorderStroke(1.dp, Color.White),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(4.dp)

        ){
            AsyncImage(
                model = "${MOVIE_IMAGE_URL}${person?.profile_path}",
                contentDescription = "Actor Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
            )

            Text(text = person?.name ?: "UnKnown", fontWeight = FontWeight.Bold,
                fontSize = 12.sp, color = Blue900, maxLines = 2,
                modifier = Modifier
                    .padding(horizontal = 6.dp)
                    .fillMaxWidth())



            Spacer(modifier = Modifier.size(6.dp))


        }
    }



}