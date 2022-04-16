package android.example.tv_show

import android.example.tv_show.navigation.SetupNavigation
import android.example.tv_show.ui.screens.all_movies.AllMoviesScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.example.tv_show.ui.theme.Tv_showTheme
import android.example.tv_show.ui.viewmodel.AllMovieScreenViewModel
import android.example.tv_show.ui.viewmodel.SingleMovieViewModel
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint


@OptIn(ExperimentalAnimationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val allMovieViewModel: AllMovieScreenViewModel by viewModels()
    private val singleViewModel:SingleMovieViewModel by viewModels()

    private lateinit var navController: NavHostController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tv_showTheme {
                navController= rememberAnimatedNavController()

                SetupNavigation(
                    navController = navController,
                    allMovieViewModel=allMovieViewModel,
                    singleMovieViewModel =singleViewModel
                )


            }
        }
    }






}

