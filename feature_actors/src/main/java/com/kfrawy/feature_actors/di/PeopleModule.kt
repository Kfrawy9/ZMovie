package com.kfrawy.feature_actors.di

import androidx.compose.ui.tooling.preview.Preview
import androidx.transition.Visibility
import com.kfrawy.feature_actors.data.remote.PeopleApi
import com.kfrawy.feature_actors.data.repository.PeopleRepositoryImpl
import com.kfrawy.feature_actors.domain.repository.PeopleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class PeopleModule {

    @Provides
    fun provideApi(retrofit: Retrofit): PeopleApi = retrofit.create(PeopleApi::class.java)

    @Provides
    fun provideRepo(repositoryImpl: PeopleRepositoryImpl): PeopleRepository = repositoryImpl

}