package android.example.tv_show.ui.screens.single_movie

import android.example.tv_show.data.models.ShowCast
import android.example.tv_show.data.models.TvShow
import android.example.tv_show.utils.ResponseState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SingleMovieContent(
    tvShow: TvShow,
    castResponseState: ResponseState<List<ShowCast>>,
    navigateToAllMovieScreen: () -> Unit,
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)

    ) {

        tvShow.apply {
            HeaderContent(
                url = image.original,
                title = name,
                rating = rating.average,
                height = 300.dp,
                genres=genres,
                navigateToAllMovieScreen

            )

            SingleMovieDescription(description = summary)



            SingleMovieCastContainer(castResponseState=castResponseState)

        }



    }


}


