package com.kfrawy.feature_actors.domain.usecase

import androidx.paging.PagingData
import com.kfrawy.feature_actors.domain.model.People
import com.kfrawy.feature_actors.domain.repository.PeopleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPeopleUseCase @Inject constructor(val repo: PeopleRepository) {

    operator fun invoke(): Flow<PagingData<People>>{
        return repo.getTrendingPeople()
    }

}