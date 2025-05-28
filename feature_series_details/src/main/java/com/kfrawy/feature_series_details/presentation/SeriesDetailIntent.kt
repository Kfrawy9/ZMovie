package com.kfrawy.feature_series_details.presentation

sealed class SeriesDetailIntent {

    class GetSeriesDetails(val seriesId: Int): SeriesDetailIntent()
    class MovieClicked(val seriesId: Int): SeriesDetailIntent()

}