package android.example.tv_show.ui.screens.all_movies

import android.example.tv_show.ui.theme.APP_BAR_ELEVATION
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import java.util.*

@Composable
fun AllMovieScreenTopBar() {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Tv Shows".toUpperCase(Locale.getDefault()),
                textAlign = TextAlign.Center,
                letterSpacing = 2.sp,
                fontSize = 16.sp


            )
        },
        elevation = APP_BAR_ELEVATION,

        )
}


@Composable
@Preview
private fun PreviewTopBar(){
    AllMovieScreenTopBar()
}
