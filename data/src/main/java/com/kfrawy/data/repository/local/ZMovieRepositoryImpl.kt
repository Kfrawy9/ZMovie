package com.kfrawy.data.repository.local

import com.kfrawy.core.utils.Result
import com.kfrawy.data.local.ZMovieDao
import com.kfrawy.data.model.Show
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ZMovieRepositoryImpl @Inject constructor(val dao: ZMovieDao): ZMovieRepository {

     override suspend fun insert(show: Show) {
        withContext(Dispatchers.IO) {
            dao.insert(show)
        }
    }

     override suspend fun delete(show: Show) {
        withContext(Dispatchers.IO) {
            dao.delete(show)
        }
    }

    override fun getWatchlist(): Flow<List<Show>> = dao.getWatchlist()
}