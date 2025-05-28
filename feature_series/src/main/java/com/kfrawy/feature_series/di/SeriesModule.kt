package com.kfrawy.feature_series.di

import com.kfrawy.feature_series.data.remote.RemoteSource
import com.kfrawy.feature_series.data.remote.RemoteSourceImpl
import com.kfrawy.feature_series.data.repository.SeriesRepositoryImpl
import com.kfrawy.feature_series.domain.repository.SeriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SeriesModule {

    @Binds
    @Singleton
    abstract fun provideRemoteSource(sourceImpl: RemoteSourceImpl): RemoteSource


    @Binds
    @Singleton
    abstract fun provideRepository(repository: SeriesRepositoryImpl): SeriesRepository
}