package com.kfrawy.feature_watchlist.presentation

import com.kfrawy.data.model.Show

sealed class WatchListIntent {

    object LoadWatchList: WatchListIntent()
    class DeleteShow(val show: Show): WatchListIntent()

}