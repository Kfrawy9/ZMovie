package com.kfrawy.feature_movie_details.data.remote

import com.kfrawy.core.component.model.Cast
import com.kfrawy.core.component.model.Image
import com.kfrawy.core.utils.Result
import com.kfrawy.core.component.model.Review
import com.kfrawy.core.component.model.Video
import com.kfrawy.core.utils.ErrorTypes
import com.kfrawy.core.utils.Result.Error
import com.kfrawy.core.utils.Result.Success
import com.kfrawy.data.model.Movie
import com.kfrawy.feature_movie_details.data.MovieApi
import com.kfrawy.feature_movie_details.domain.model.MovieDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(val api: MovieApi): RemoteSource {

    override fun getMovieDetails(movieId: Int): Flow<Result<MovieDetail>> =
        flow {
            try {
                val result = api.getMovieDetail(movieId)
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

    override fun getMovieCasts(movieId: Int): Flow<Result<List<Cast>>> =
        flow {
            try {
                val result = api.getMovieCredits(movieId)
                if (result.isSuccessful){
                    result.body()?.let {
                        if (it.cast.isNotEmpty())
                            emit(Success(it.cast))
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

    override  fun getMovieVideo(movieId: Int): Flow<Result<List<Video>>> =
        flow {
            try {
                val result = api.getMovieVideos(movieId)
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

    override fun getMovieReviews(movieId: Int): Flow<Result<List<Review>>> =
        flow {
            try {
                val result = api.getMovieReview(movieId, 1)
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


    override  fun getMovieImages(movieId: Int): Flow<Result<List<Image>>> =
        flow {
            try {
                val result = api.getMovieImages(movieId)
                if (result.isSuccessful){
                    result.body()?.let {
                        if (it.backdrops.isNotEmpty())
                            emit(Success(it.backdrops))
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

    override  fun getMovieRecommendation(movieId: Int): Flow<Result<List<Movie>>> =
    flow {
        try {
            val result = api.getRecommendationsMovies(movieId, 1)
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

    override  fun getSimilarMovie(movieId: Int): Flow<Result<List<Movie>>> =
        flow {

                val result = api.getSimilarMovies(movieId, 1)
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


        }.catch {  }
}