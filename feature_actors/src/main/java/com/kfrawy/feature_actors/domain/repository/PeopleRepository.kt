package com.kfrawy.feature_actors.domain.repository

import androidx.paging.PagingData
import com.kfrawy.feature_actors.domain.model.People
import kotlinx.coroutines.flow.Flow

interface PeopleRepository {
    fun getTrendingPeople(): Flow<PagingData<People>>
}