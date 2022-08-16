package android.example.tv_show.ui.screens.all_movies

import android.example.tv_show.component.MovieCard
import android.example.tv_show.data.models.TvShow
import android.example.tv_show.simmer.all_movie.AllMoviesSimmerAnimationLoadingScreen
import android.example.tv_show.utils.ResponseState
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun AllMovieContent(
    responseState: ResponseState<List<TvShow>>,
    navigateToSingleMovieScreen: (Int) -> Unit
) {

    when(responseState){
        is ResponseState.Success ->{
            val listOfTvShow = responseState.result

            LazyColumn() {
                items(
                    items = listOfTvShow,
                    key = { tvShow ->
                        tvShow.id
                    }
                ) { tvShow ->
                    MovieCard(
                        imgUrl = tvShow.image.medium,
                        title = tvShow.name,
                        rating = tvShow.rating.average,
                        padding = 5.dp,
                        summery = tvShow.summary,
                        onClick = {
                            navigateToSingleMovieScreen(tvShow.id)
                        }
                    )
                }
            }
        }


        is ResponseState.Loading -> {
            AllMoviesSimmerAnimationLoadingScreen()
        }

    }




}
