package android.example.tv_show.ui.screens.all_movies

import android.example.tv_show.data.models.TvShow
import android.example.tv_show.ui.theme.*
import android.example.tv_show.utils.ResponseState
import android.text.Spanned
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat

@Composable
fun AllMoviesScreen(

    responseState: ResponseState<List<TvShow>>,
    navigateToSingleMovieScreen: (Int) -> Unit

) {

    Scaffold(
        topBar = { AllMovieScreenTopBar() },
        content = { AllMovieContent(responseState,navigateToSingleMovieScreen=navigateToSingleMovieScreen ) },
    )


}









@Composable
fun Rating(
    width: Dp,
    rating: Float
) {

    Row(
        modifier = Modifier
            .width(width)
            .height(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            tint = Color.Yellow,
            contentDescription = "Star-Icon",
        )

        Text(
            text = "$rating",
            fontSize = 14.sp,
            color = MaterialTheme.colors.contentTextColor
        )

    }


}








fun String?.toHtml(): Spanned? {
    if (this.isNullOrEmpty()) return null
    return HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_COMPACT)
}