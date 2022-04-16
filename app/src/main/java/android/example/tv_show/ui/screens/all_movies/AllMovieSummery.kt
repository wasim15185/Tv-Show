package android.example.tv_show.ui.screens.all_movies

import android.example.tv_show.ui.theme.MediumGray
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AllMovieSummery(text: String) {

    Text(
        modifier = Modifier.padding(end = 4.dp),
        text = "${text.toHtml()}",
        fontSize = 13.sp,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        color = MediumGray
    )

}


