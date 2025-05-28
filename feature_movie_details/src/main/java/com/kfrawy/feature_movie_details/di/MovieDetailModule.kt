package com.kfrawy.feature_movie_details.di

import androidx.compose.ui.tooling.preview.Preview
import com.kfrawy.feature_movie_details.data.MovieApi
import com.kfrawy.feature_movie_details.data.MovieDetailRepositoryImpl
import com.kfrawy.feature_movie_details.data.remote.RemoteSource
import com.kfrawy.feature_movie_details.data.remote.RemoteSourceImpl
import com.kfrawy.feature_movie_details.domain.repository.MovieDetailRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 class MovieDetailModule {

    @Provides
    fun provideApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)

    @Provides
     fun provideRepo(repositoryImpl: MovieDetailRepositoryImpl): MovieDetailRepository{
        return repositoryImpl
    }

    @Provides
     fun provideSource(remoteSourceImpl: RemoteSourceImpl): RemoteSource{
         return remoteSourceImpl
    }

}