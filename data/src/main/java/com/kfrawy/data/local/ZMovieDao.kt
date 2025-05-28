package com.kfrawy.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kfrawy.data.model.Show
import kotlinx.coroutines.flow.Flow

@Dao
interface ZMovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(show: Show)

    @Delete
    suspend fun delete(show: Show)

    @Query("SELECT * FROM show")
    fun getWatchlist(): Flow<List<Show>>

}