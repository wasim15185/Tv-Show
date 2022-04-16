package android.example.tv_show.navigation

import android.example.tv_show.ui.screens.all_movies.AllMoviesScreen
import android.example.tv_show.ui.viewmodel.AllMovieScreenViewModel
import android.example.tv_show.utils.NavRouteHolder
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.allMovieComposable(
    allMovieScreenViewModel: AllMovieScreenViewModel,
    navigateToSingleMovieScreen:(Int)->Unit
) {
    composable(
        route = NavRouteHolder.AllMovie.route,

        enterTransition = {
            when (initialState.destination.route) {
                NavRouteHolder.SingleMovie.route ->
                    slideInHorizontally(
                        initialOffsetX = { 300 },
                        animationSpec = tween(300)
                    ) + fadeIn(animationSpec = tween(300))
                else -> null
            }
        },

        exitTransition = {
            when (targetState.destination.route) {
                NavRouteHolder.SingleMovie.route ->
                    slideOutHorizontally(
                        targetOffsetX = { -300 },
                        animationSpec = tween(300)
                    ) + fadeOut(animationSpec = tween(300))
                else -> null
            }
        } ,

        popEnterTransition = {
            when (initialState.destination.route) {
                NavRouteHolder.SingleMovie.route ->
                    slideInHorizontally(
                        initialOffsetX = { -300 },
                        animationSpec = tween(300)
                    ) + fadeIn(animationSpec = tween(300))
                else -> null
            }

        },

//        popExitTransition = {}


    ) { navBackStackEntry ->

        LaunchedEffect(key1 = true) {
            allMovieScreenViewModel.fetchAllTvShow()
        }

        val responseState by allMovieScreenViewModel.responseState.collectAsState()

        AllMoviesScreen(
            responseState = responseState,
            navigateToSingleMovieScreen=navigateToSingleMovieScreen
        )



    }

}