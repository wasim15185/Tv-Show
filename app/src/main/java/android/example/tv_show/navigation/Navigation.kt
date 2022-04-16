package android.example.tv_show.navigation

import android.example.tv_show.ui.viewmodel.AllMovieScreenViewModel
import android.example.tv_show.ui.viewmodel.SingleMovieViewModel
import android.example.tv_show.utils.NavRouteHolder
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SetupNavigation(
    navController: NavHostController,
    allMovieViewModel : AllMovieScreenViewModel,
    singleMovieViewModel: SingleMovieViewModel
){

    val screen = remember(navController) {
        Screen(navController)
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = NavRouteHolder.AllMovie.route
    ){

        allMovieComposable(allMovieViewModel , navigateToSingleMovieScreen = screen.singleMovie )
        singleMovieComposable(
            singleMovieViewModel,
//            navigateToAllMovieScreen = screen.allMovie
            navigateToAllMovieScreen = { navController.popBackStack() }
        )


    }





}