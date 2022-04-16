package android.example.tv_show.navigation

import android.example.tv_show.ui.screens.single_movie.SingleMovieScreen
import android.example.tv_show.ui.viewmodel.SingleMovieViewModel
import android.example.tv_show.utils.NavRouteHolder
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.singleMovieComposable(
    singleMovieViewModel: SingleMovieViewModel,
    navigateToAllMovieScreen: () -> Unit
) {
    composable(
        route = NavRouteHolder.SingleMovie.route,
        listOf(
            navArgument(NavRouteHolder.SingleMovie.getArgument_key()) {
                type = NavType.IntType
            }
        ),

        enterTransition = {
            when (initialState.destination.route) {
                NavRouteHolder.AllMovie.route ->
                    slideInHorizontally(
                        initialOffsetX = { 300 },
                        animationSpec = tween(300)
                    ) + fadeIn(animationSpec = tween(300))
                else -> null
            }

        },

        exitTransition = {
            when (targetState.destination.route) {
                NavRouteHolder.AllMovie.route ->
                    slideOutHorizontally(
                        targetOffsetX = { -300 },
                        animationSpec = tween(300)
                    ) + fadeOut(animationSpec = tween(300))
                else -> null
            }


        } ,

//        popEnterTransition = {},

        popExitTransition = {
            when (targetState.destination.route) {
                NavRouteHolder.AllMovie.route ->
                    slideOutHorizontally(
                        targetOffsetX = { 300 },
                        animationSpec = tween(300)
                    ) + fadeOut(animationSpec = tween(300))
                else -> null
            }

        }

    ) { navBackStackEntry ->

        val argument =
            navBackStackEntry.arguments?.getInt(NavRouteHolder.SingleMovie.getArgument_key())

        LaunchedEffect(key1 = argument ) {
            singleMovieViewModel.fetchTvShow(argument!!)
            singleMovieViewModel.fetchShowCast(argument)
        }

        val responseState by singleMovieViewModel.responseState.collectAsState()
        val castResponseState by singleMovieViewModel.castResponseState.collectAsState()



        SingleMovieScreen(
            responseState,
            navigateToAllMovieScreen = navigateToAllMovieScreen,
            castResponseState=castResponseState
        )


    }


}