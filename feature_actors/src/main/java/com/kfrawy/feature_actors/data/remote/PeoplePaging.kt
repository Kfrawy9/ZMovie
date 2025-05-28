package com.kfrawy.feature_actors.data.remote

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kfrawy.feature_actors.domain.model.People

class PeoplePaging(val api: PeopleApi): PagingSource<Int, People>(){

    override fun getRefreshKey(state: PagingState<Int, People>): Int? {
        return state.anchorPosition?.let {
            val closestPosition = state.closestPageToPosition(it)
            closestPosition?.prevKey?.plus(1) ?: closestPosition?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, People> {

        try {
            val page = params.key ?: 1
            val response = api.getTrendingPeople(page)
            val result = response.body()?.results ?: emptyList()
            return LoadResult.Page(
                data = result,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (result.isEmpty()) null else page + 1
            )
        }catch (ex: Throwable){
            Log.d("PeopleError", "size from response: ${ex.message} ")
            return LoadResult.Error(ex)
        }
    }
}