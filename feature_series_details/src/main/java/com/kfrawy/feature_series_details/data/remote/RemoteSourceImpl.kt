package com.kfrawy.feature_series_details.data.remote

import android.util.Log
import com.kfrawy.core.component.model.Cast
import com.kfrawy.core.component.model.Image
import com.kfrawy.core.component.model.Review
import com.kfrawy.core.component.model.Video
import com.kfrawy.core.utils.ErrorTypes
import com.kfrawy.core.utils.Result
import com.kfrawy.core.utils.Result.Error
import com.kfrawy.core.utils.Result.Success
import com.kfrawy.data.model.Movie
import com.kfrawy.data.model.Series
import com.kfrawy.feature_series_details.domain.model.SeriesDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(val api: SeriesDetailApi): RemoteSource {

    override fun getSeriesDetails(seriesId: Int): Flow<Result<SeriesDetail>> =
        flow {
            try {
                val result = api.getSeriesDetail(seriesId)
                if (result.isSuccessful){
                    result.body()?.let {
                        emit(Success(it))
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
    override fun getSeriesCasts(seriesId: Int): Flow<Result<List<Cast>>> =
        flow {
            try {
                val result = api.getSeriesCredits(seriesId)
                if (result.isSuccessful){
                    result.body()?.let {
                        emit(Success(it.cast))
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

    override fun getSeriesReviews(seriesId: Int): Flow<Result<List<Review>>> =
        flow {
            try {
                val result = api.getSeriesReview(seriesId, 1)
                if (result.isSuccessful){
                    result.body()?.let {
                        emit(Success(it.results))
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


    override fun getSeriesImages(seriesId: Int): Flow<Result<List<Image>>> =
        flow {
            try {
                val result = api.getSeriesImages(seriesId)
                if (result.isSuccessful){
                    result.body()?.let {
                        emit(Success(it.backdrops))
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

    override fun getSeriesVideo(seriesId: Int): Flow<Result<List<Video>>> =
        flow {
            try {
                val result = api.getSeriesVideos(seriesId)
                if (result.isSuccessful){
                    result.body()?.let {
                        emit(Success(it.results))
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
    override fun getSeriesRecommendation(seriesId: Int): Flow<Result<List<Series>>> =
        flow {
            try {
                val result = api.getRecommendationsSeries(seriesId, 1)
                if (result.isSuccessful){
                    result.body()?.let {
                        Log.d("LaterOn", "${it.results}")
                        emit(Success(it.results))
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

    override fun getSimilarSeries(seriesId: Int): Flow<Result<List<Series>>> =
        flow {
            try {
                val result = api.getSimilarSeries(seriesId, 1)
                if (result.isSuccessful){
                    result.body()?.let {
                        Log.d("LaterOn", "${it.results}")
                        emit(Success(it.results))
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
}