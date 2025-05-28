package com.kfrawy.feature_actors.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kfrawy.feature_actors.data.remote.PeopleApi
import com.kfrawy.feature_actors.data.remote.PeoplePaging
import com.kfrawy.feature_actors.domain.model.People
import com.kfrawy.feature_actors.domain.repository.PeopleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(val api: PeopleApi) : PeopleRepository {
    override fun getTrendingPeople(): Flow<PagingData<People>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 40,
                maxSize = 100,
            ),
            pagingSourceFactory = { PeoplePaging(api) }
        ).flow
    }
}