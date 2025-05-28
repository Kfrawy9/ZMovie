package com.kfrawy.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Show(
    @PrimaryKey
    val id: Int,
    val title: String,
    val poster_path: String?,
    val popularity: Double,
    val year: Int,
    val bookmarked: Boolean,
)
