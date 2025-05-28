package com.kfrawy.data.repository.local

import com.kfrawy.core.utils.Result
import com.kfrawy.data.model.Show
import kotlinx.coroutines.flow.Flow

interface ZMovieRepository {

    suspend fun insert(show: Show)
    suspend fun delete(show: Show)
    fun getWatchlist(): Flow<List<Show>>


}