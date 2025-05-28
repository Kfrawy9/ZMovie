package com.kfrawy.feature_movie.utils

import com.kfrawy.core.component.model.HorizontalData
import com.kfrawy.data.model.Movie
import com.kfrawy.data.model.Show

object Mapper {

    fun toHorizontalData(data: List<Movie>): List<HorizontalData>{
        val hData: MutableList<HorizontalData> = mutableListOf()
        data.forEach {
            val year: Int = it.release_date.take(4).toInt()
            hData.add(HorizontalData(it.id, it.title, it.poster_path ?: "", it.vote_average, year))
        }
        return hData
    }

    fun toShow(data: HorizontalData): Show{
        return Show(data.id, data.title, data.url, data.rating, data.year, data.bookmarked)
    }



}