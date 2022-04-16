package android.example.tv_show.ui.screens.single_movie

import android.example.tv_show.ui.screens.all_movies.toHtml
import android.example.tv_show.ui.theme.MediumGray
import android.example.tv_show.ui.theme.contentTextColor
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SingleMovieDescription(
    modifier: Modifier = Modifier,
    description: String,

    ) {

    Column() {
        Text(
            modifier = Modifier.padding(top = 8.dp, start = 16.dp),
            text = "Synopsis :",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.contentTextColor,
        )

        Spacer(modifier = Modifier.height(7.dp))

        Text(
            modifier = Modifier
                .padding(top = 4.dp, start = 16.dp, end = 16.dp),
            text = "${description.toHtml()}",
            color = MediumGray,
            fontSize = 16.sp,
        )

    }


}