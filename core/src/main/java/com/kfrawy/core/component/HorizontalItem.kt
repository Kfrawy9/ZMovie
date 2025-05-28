package com.kfrawy.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.kfrawy.core.R
import com.kfrawy.core.component.model.HorizontalData
import com.kfrawy.core.utils.Colors
import com.kfrawy.core.utils.MOVIE_IMAGE_URL

@Composable
fun HorizontalItem(
    item: HorizontalData,
    onItemClicked:(itemId: Int) -> Unit,
    onBookMarkClicked:(itemId: HorizontalData, bookmarkState: Boolean) -> Unit
) {

    var bookmark by remember{ mutableStateOf(item.bookmarked) }

    Card(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .width(155.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(6.dp),
        onClick = { onItemClicked(item.id) }
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.Transparent)
        ) {
            AsyncImage(
                model = "$MOVIE_IMAGE_URL${item.url}",
                contentDescription = "Item Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(155.dp),
                contentScale = ContentScale.FillBounds,
            )


            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(6.dp)
            ){
                Column(modifier = Modifier.weight(0.9f),
                    verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        item.title,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.Black,
                        lineHeight = TextUnit(14.0f, TextUnitType.Sp),
                        modifier = Modifier.height(30.dp)
                    )


                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    )
                    {
                        Text(
                            "${item.year}",
                            fontSize = 10.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Colors.Blue900,
                        )

                        Icon(
                            painter = painterResource(R.drawable.baseline_star),
                            contentDescription = "Star",
                            tint = Color.Yellow,
                            modifier = Modifier
                                .size(14.dp)
                                .align(Alignment.CenterVertically)
                        )

                        Text(
                            "${item.rating}",
                            fontSize = 10.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.Black,
                        )

                    }
                }



                Icon(
                    painter = if (bookmark)
                        painterResource(R.drawable.filled_bookmark)
                    else
                        painterResource(R.drawable.outline_bookmark)
                    ,
                    contentDescription = "Bookmark",
                    tint = Color.Black,
                    modifier = Modifier.size(23.dp).clickable{
                        bookmark = !bookmark
                        onBookMarkClicked(item, bookmark)
                    }
                )

            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
}