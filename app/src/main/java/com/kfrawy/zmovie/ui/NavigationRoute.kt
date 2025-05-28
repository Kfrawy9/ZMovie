package com.kfrawy.zmovie.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.kfrawy.feature_actors.presentation.PeopleItem
import com.kfrawy.feature_actors.presentation.PeopleScreen
import com.kfrawy.feature_movie.presentation.Movie
import com.kfrawy.feature_movie_details.presentation.MovieDetails
import com.kfrawy.feature_series.presentation.Series
import com.kfrawy.feature_series_details.presentation.SeriesDetails
import com.kfrawy.feature_watchlist.presentation.WatchList
import com.kfrawy.zmovie.utils.ActorRoute
import com.kfrawy.zmovie.utils.MovieDetail
import com.kfrawy.zmovie.utils.MovieRoute
import com.kfrawy.zmovie.utils.SeriesDetail
import com.kfrawy.zmovie.utils.SeriesRoute
import com.kfrawy.zmovie.utils.WatchListRoute

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationRoute(controller: NavHostController){

    NavHost (controller, startDestination =  MovieRoute){


        composable<MovieRoute> {
            Movie{
                controller.navigate(MovieDetail(it))
            }
        }

        composable<SeriesRoute> {
            Series{
                controller.navigate(SeriesDetail(it))
            }
        }

        composable<WatchListRoute> {
            WatchList {
            }
        }

        composable<ActorRoute> {
            PeopleScreen {

            }
        }

        composable<MovieDetail> {
            val movieId = it.toRoute<MovieDetail>().movieId
            MovieDetails(movieId)
        }

        composable<SeriesDetail> {
            val seriesId = it.toRoute<SeriesDetail>().seriesId
            SeriesDetails(seriesId)
        }

    }


}