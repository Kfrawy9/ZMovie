package com.kfrawy.feature_movie.data

import com.kfrawy.core.utils.ErrorTypes
import com.kfrawy.core.utils.Result
import com.kfrawy.core.utils.Result.Success
import com.kfrawy.core.utils.Result.Error
import com.kfrawy.core.utils.Result.Loading
import com.kfrawy.data.model.Movie
import com.kfrawy.data.remote.ZMovieAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(val api: ZMovieAPI): RemoteSource {

    override suspend fun getTrendingMovies(): Flow<Result<List<Movie>>> =
        flow {
            try {

                val result = api.getTrendingMovies(1)
                if (result.isSuccessful){
                    result.body()?.let {
                        if (it.results.isNotEmpty())
                            emit(Success(it.results))
                        else
                            emit(Error(ErrorTypes.EmptyData))
                    }
                }else{
                    val code = result.code()
                    if (code in (400 .. 499))
                        emit(Error(ErrorTypes.ClientError(result.message())))
                    else
                        emit(Error(ErrorTypes.ServerError(result.message())))
                }
            }catch (ex: Exception){
                emit(Error(ErrorTypes.ClientError(ex.message ?: "UnKnown Error")))
            }

        }

    override suspend fun getUpComingMovies(): Flow<Result<List<Movie>>> =
        flow {
            try {

                val result = api.getUpComingMovies(1)
                if (result.isSuccessful){
                    result.body()?.let {
                        if (it.results.isNotEmpty())
                            emit(Success(it.results))
                        else
                            emit(Error(ErrorTypes.EmptyData))
                    }
                }else{
                    val code = result.code()
                    if (code in (400 .. 499))
                        emit(Error(ErrorTypes.ClientError(result.message())))
                    else
                        emit(Error(ErrorTypes.ServerError(result.message())))
                }
            }catch (ex: Exception){
                emit(Error(ErrorTypes.ClientError(ex.message ?: "UnKnown Error")))
            }

        }

    override suspend fun getPopularMovies(): Flow<Result<List<Movie>>> =
        flow {
            try {

                val result = api.getPopularMovies(1)
                if (result.isSuccessful){
                    result.body()?.let {
                        if (it.results.isNotEmpty())
                            emit(Success(it.results))
                        else
                            emit(Error(ErrorTypes.EmptyData))
                    }
                }else{
                    val code = result.code()
                    if (code in (400 .. 499))
                        emit(Error(ErrorTypes.ClientError(result.message())))
                    else
                        emit(Error(ErrorTypes.ServerError(result.message())))
                }
            }catch (ex: Exception){
                emit(Error(ErrorTypes.ClientError(ex.message ?: "UnKnown Error")))
            }

        }

    override suspend fun getTopRatedMovies(): Flow<Result<List<Movie>>> =
        flow {
            try {

                val result = api.getTopRatedMovies(1)
                if (result.isSuccessful){
                    result.body()?.let {
                        if (it.results.isNotEmpty())
                            emit(Success(it.results))
                        else
                            emit(Error(ErrorTypes.EmptyData))
                    }
                }else{
                    val code = result.code()
                    if (code in (400 .. 499))
                        emit(Error(ErrorTypes.ClientError(result.message())))
                    else
                        emit(Error(ErrorTypes.ServerError(result.message())))
                }
            }catch (ex: Exception){
                emit(Error(ErrorTypes.ClientError(ex.message ?: "UnKnown Error")))
            }

        }

    override suspend fun getNowPlayingMovies(): Flow<Result<List<Movie>>> =
        flow {
            try {

                val result = api.getNowPlayingMovies(1)
                if (result.isSuccessful){
                    result.body()?.let {
                        if (it.results.isNotEmpty())
                            emit(Success(it.results))
                        else
                            emit(Error(ErrorTypes.EmptyData))
                    }
                }else{
                    val code = result.code()
                    if (code in (400 .. 499))
                        emit(Error(ErrorTypes.ClientError(result.message())))
                    else
                        emit(Error(ErrorTypes.ServerError(result.message())))
                }
            }catch (ex: Exception){
                emit(Error(ErrorTypes.ClientError(ex.message ?: "UnKnown Error")))
            }

        }
}