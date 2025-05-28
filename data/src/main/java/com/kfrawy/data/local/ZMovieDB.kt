package com.kfrawy.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kfrawy.data.model.Show

@Database(entities = [Show::class], version = 2)
abstract class ZMovieDB:RoomDatabase() {
    abstract fun zMovieDao(): ZMovieDao
}