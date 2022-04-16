package android.example.tv_show.ui.screens.single_movie

import android.example.tv_show.data.models.ShowCast
import android.example.tv_show.ui.theme.contentTextColor
import android.example.tv_show.utils.ResponseState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun SingleMovieCastContainer(castResponseState: ResponseState<List<ShowCast>>) {

    if (castResponseState is ResponseState.Success) {
        val showCastList = castResponseState.result
        MovieCastContainer(showCastList)
    }


}

@Composable
fun MovieCastContainer(
    showCastList: List<ShowCast>
) {

    Column {

        Text(
            modifier = Modifier.padding(top = 8.dp, start = 16.dp),
            text = "Cast :",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.contentTextColor,
        )

        Spacer(modifier = Modifier.height(7.dp))

        LazyRow(
            modifier = Modifier
                .height(140.dp)
        ) {
            items(
                items = showCastList,
                key = { showCast ->
                    showCast.character.id
                }
            ) { showCast ->
                SingleMovieCastItem(showCast.person.image.medium, showCast.person.name)
            }
        }
    }
}