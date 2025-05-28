package com.kfrawy.feature_series.presentation.utlis

import android.os.Build
import androidx.annotation.RequiresApi
import com.kfrawy.core.component.model.HorizontalData
import com.kfrawy.data.model.Movie
import com.kfrawy.data.model.Series
import com.kfrawy.data.model.Show
import java.time.LocalDate

object Mapper {

    @RequiresApi(Build.VERSION_CODES.O)
    fun toHorizontalData(data: List<Series>): List<HorizontalData>{
        val hData: MutableList<HorizontalData> = mutableListOf()
        data.forEach {
            val year =
                if (it.first_air_date.isNotEmpty()) LocalDate.parse(it.first_air_date).year
                else 0
            hData.add(HorizontalData(it.id, it.name, it.poster_path ?: "", it.vote_average, year))
        }
        return hData
    }

    fun toShow(data: HorizontalData): Show{
        return Show(data.id, data.title, data.url, data.rating, data.year, data.bookmarked)
    }



}