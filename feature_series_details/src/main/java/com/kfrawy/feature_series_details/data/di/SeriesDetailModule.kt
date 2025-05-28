package com.kfrawy.feature_series_details.data.di

import com.kfrawy.feature_series_details.data.remote.RemoteSource
import com.kfrawy.feature_series_details.data.remote.RemoteSourceImpl
import com.kfrawy.feature_series_details.data.remote.SeriesDetailApi
import com.kfrawy.feature_series_details.data.repository.SeriesDetailRepositoryImpl
import com.kfrawy.feature_series_details.domain.repository.SeriesDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class SeriesDetailModule {

    @Provides
    fun provideApi(retrofit: Retrofit): SeriesDetailApi{
        return retrofit.create(SeriesDetailApi::class.java)
    }

    @Provides
    fun provideRepository(repo: SeriesDetailRepositoryImpl): SeriesDetailRepository{
        return repo
    }

    @Provides
    fun provideRemote(remote: RemoteSourceImpl): RemoteSource{
        return remote
    }
}