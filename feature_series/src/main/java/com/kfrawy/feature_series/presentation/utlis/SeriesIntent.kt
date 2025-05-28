package com.kfrawy.feature_series.presentation.utlis

import com.kfrawy.data.model.Series
import com.kfrawy.data.model.Show

sealed class SeriesIntent {

    object loadSeries: SeriesIntent()
    class showMore(val type: Int): SeriesIntent()
    class seriesClicked(val seriesId: Int): SeriesIntent()
    class InsertSeriesDB(val show: Show): SeriesIntent()
    class DeleteSeriesDB(val show: Show): SeriesIntent()
}