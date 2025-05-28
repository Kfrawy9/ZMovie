package com.kfrawy.feature_series.data.remote

import com.kfrawy.core.utils.ErrorTypes
import com.kfrawy.core.utils.Result
import com.kfrawy.core.utils.Result.Error
import com.kfrawy.core.utils.Result.Success
import com.kfrawy.data.model.Movie
import com.kfrawy.data.model.Series
import com.kfrawy.data.remote.ZMovieAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(val api: ZMovieAPI): RemoteSource {

    override fun getTrendingShow(): Flow<Result<List<Series>>> =
        flow {
            try {

                val result = api.getTrendingSeries(1)
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

    override fun getAiringTodayShow(): Flow<Result<List<Series>>> =
        flow {
            try {

                val result = api.getAiringTodaySeries(1)
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
            }catch (ex: NullPointerException){
                emit(Error(ErrorTypes.ClientError(ex.message ?: "UnKnown Error")))
            }

        }

    override  fun getPopularShow(): Flow<Result<List<Series>>> =
        flow {
            try {

                val result = api.getPopularSeries(1)
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

    override fun getTopRatedShow(): Flow<Result<List<Series>>> =
        flow {
            try {

                val result = api.getTopRatedSeries(1)
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

    override fun getOnTheAirShow(): Flow<Result<List<Series>>> =
        flow {
            try {

                val result = api.getOnTheAirSeries(1)
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