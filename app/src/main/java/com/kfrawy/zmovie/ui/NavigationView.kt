package com.kfrawy.zmovie.ui

import android.provider.CalendarContract
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import com.kfrawy.zmovie.R
import com.kfrawy.zmovie.utils.bottomList
import com.kfrawy.zmovie.utils.routes

@Composable
fun NavigationView(controller: NavHostController){
    var selectedItem by remember { mutableStateOf(0) }
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(containerColor = Color.White) {

                bottomList.forEachIndexed {index, navItem->

                    NavigationBarItem(
                        selected = index == selectedItem,
                        onClick = {
                            selectedItem = index
                            controller.navigate(routes[selectedItem])
                        },
                        icon = {
                            val icon = if (selectedItem == index) bottomList[index].filledIcon
                            else bottomList[index].outlineIcon

                            Icon(
                                imageVector = ImageVector.vectorResource(icon),
                                contentDescription = "Icon",
                            )

                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Blue
                        )

                    )

                }
            }
        }) { innerPadding ->

        Box(modifier = Modifier.padding(innerPadding)){
            NavigationRoute(controller)
        }

    }
}

