package com.kfrawy.feature_movie_details.presentation

sealed class MovieDetailIntent {

    class getMovieDetails(val movieId: Int): MovieDetailIntent()
    class MovieClicked(val movieId: Int): MovieDetailIntent()

}