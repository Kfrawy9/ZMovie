package com.kfrawy.feature_movie.data.di

import com.kfrawy.feature_movie.data.RemoteSource
import com.kfrawy.feature_movie.data.RemoteSourceImpl
import com.kfrawy.feature_movie.data.repository.MovieRepositoryImpl
import com.kfrawy.feature_movie.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieModule {

    @Binds
    @Singleton
    abstract fun provideRemoteSource(source: RemoteSourceImpl): RemoteSource

    @Binds
    @Singleton
    abstract fun provideMovieRepository(repo: MovieRepositoryImpl): MovieRepository

}