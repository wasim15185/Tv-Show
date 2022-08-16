package android.example.tv_show.simmer.all_movie

import android.example.tv_show.ui.theme.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AllMovieSimmerItem (
    brush: Brush,
    padding: Dp,
){
    Card(
        modifier = Modifier
            .padding(
                top = padding,
                bottom = padding,
                start = CARD_ITEM_LEFT_RIGHT_PADDING,
                end = CARD_ITEM_LEFT_RIGHT_PADDING
            )
            .fillMaxWidth()
            .height(CARD_HEIGHT),
        elevation = ELEVATION_CARD_ITEM,
        shape = RoundedCornerShape(CARD_CORNER_RADIUS),
        backgroundColor = MaterialTheme.colors.cardItemBackgroundColor,
        border = BorderStroke(0.5.dp, MaterialTheme.colors.cardBorderColor),

        ){
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = brush)
        )
    }
}