package com.kfrawy.feature_actors.data.remote

import com.kfrawy.feature_actors.domain.model.PeopleResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PeopleApi {

    @GET("person/popular")
    suspend fun getTrendingPeople(@Query("page") page: Int): Response<PeopleResult>

}