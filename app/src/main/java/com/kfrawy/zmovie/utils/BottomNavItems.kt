package com.kfrawy.zmovie.utils

import com.kfrawy.zmovie.R

data class BottomNavItems(
    val title: String,
    val filledIcon: Int,
    val outlineIcon: Int,
)

val bottomList = listOf<BottomNavItems>(
    BottomNavItems("Movie", R.drawable.filled_movie, R.drawable.outline_movie),
    BottomNavItems("Series", R.drawable.round_tv, R.drawable.round_tv),
    BottomNavItems("WatchList", R.drawable.filled_bookmark, R.drawable.outline_bookmark),
    BottomNavItems("Actor", R.drawable.filled_person, R.drawable.outline_person)
)