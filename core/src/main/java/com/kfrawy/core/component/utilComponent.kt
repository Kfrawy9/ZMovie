package com.kfrawy.core.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kfrawy.core.utils.Colors
import com.kfrawy.core.utils.Colors.Blue900

fun LazyListScope.Spacing(size: Dp) {
    item { Spacer(modifier = Modifier.size(size)) }
}

fun LazyListScope.HeadTitle(title: String) {
    item {
        Text(
            text = title, fontWeight = FontWeight.Bold,
            fontSize = 18.sp, color = Blue900
        )
    }
}

fun LazyListScope.EmptyDataView(type: String) {
    item {
        Text(
            "No $type found",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 12.sp
        )
    }
}

fun LazyListScope.HeadTitleNMore(title: String, onShowMoreClicked: () -> Unit) {
    item {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = title, fontWeight = FontWeight.Bold,
                fontSize = 18.sp, modifier = Modifier.weight(0.8f), color = Color.Black
            )

            Text(
                text = "Show More >",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp, color = Blue900,
                modifier = Modifier
                    .weight(0.2f)
                    .clickable(onClick = onShowMoreClicked)
            )

        }
    }
}

@Composable
fun LoadingState() {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp),
            color = Blue900
        )
    }
}

@Composable
fun ErrorView(error: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = error,
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.CenterStart)
                .align(Alignment.CenterEnd),
        )
    }
}
