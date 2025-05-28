package com.kfrawy.feature_movie.utils

import com.kfrawy.data.model.Movie
import com.kfrawy.data.model.Show

sealed class MovieIntent {
    object GetMovies: MovieIntent()
    class SeeMoreEvent(val type: MovieType): MovieIntent()
    class MovieClickedEvent(val movieId: Int): MovieIntent()
    class InsertMovieDB(val show: Show): MovieIntent()
    class DeleteMovieDB(val show: Show): MovieIntent()
}

enum class MovieType{
    TRENDING, UPCOMING, POPULAR, NOW_PLAYING, TOP_RATED
}