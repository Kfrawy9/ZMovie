package com.kfrawy.data.di

import android.content.Context
import androidx.core.os.BuildCompat
import androidx.room.Room
import com.kfrawy.data.BuildConfig
import com.kfrawy.data.local.ZMovieDB
import com.kfrawy.data.local.ZMovieDao
import com.kfrawy.data.remote.ZMovieAPI
import com.kfrawy.data.repository.local.ZMovieRepository
import com.kfrawy.data.repository.local.ZMovieRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val builder = OkHttpClient().newBuilder().addInterceptor { chain ->
            val request = chain.request().newBuilder()
            val auth = BuildConfig.AUTH
            chain.request().newBuilder()
                .addHeader("accept", "application/json")
                .addHeader(
                    "Authorization",
                    auth
                ).build()

            chain.proceed(chain.request())
        }.addInterceptor(interceptor)

        return builder.build()
    }


    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        val api_key = BuildConfig.API_KEY
        val client = okHttpClient.newBuilder()
            .addInterceptor { chain->
                val request = chain.request().newBuilder()
                val url = chain.request().url.newBuilder()
                    .addQueryParameter("api_key", api_key)
                request.url(url.build())
                val response = chain.proceed(request.build())
                return@addInterceptor response
            }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()

        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client.build())
            .build()
    }

    @Provides
    fun provideApi(retrofit: Retrofit): ZMovieAPI{
        return retrofit.create(ZMovieAPI::class.java)
    }

    @Provides
    fun provideRepository(repo: ZMovieRepositoryImpl): ZMovieRepository{
        return repo
    }

    @Provides
    fun provideRoom(@ApplicationContext context: Context): ZMovieDao{
        return Room.databaseBuilder(context, ZMovieDB::class.java, "ZMovie")
            .build().zMovieDao()
    }

}