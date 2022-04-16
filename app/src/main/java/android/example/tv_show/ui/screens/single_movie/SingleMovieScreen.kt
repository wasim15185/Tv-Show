package android.example.tv_show.ui.screens.single_movie

import android.example.tv_show.data.models.ShowCast
import android.example.tv_show.data.models.TvShow
import android.example.tv_show.utils.ResponseState
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable

@Composable
fun SingleMovieScreen(
    responseState: ResponseState<TvShow>,
    navigateToAllMovieScreen: () -> Unit,
    castResponseState: ResponseState<List<ShowCast>>

) {


    Scaffold(
        scaffoldState = rememberScaffoldState(),
        content = {
            if (responseState is ResponseState.Success) {
                val tvShow = responseState.result

                SingleMovieContent(
                    tvShow = tvShow,
                    castResponseState = castResponseState,
                    navigateToAllMovieScreen = navigateToAllMovieScreen
                )

            }
        }
    )


}

