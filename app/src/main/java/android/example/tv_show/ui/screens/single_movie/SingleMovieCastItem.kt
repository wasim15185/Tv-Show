package android.example.tv_show.ui.screens.single_movie

import android.example.tv_show.ui.theme.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SingleMovieCastItem(
    imgUrl: String,
    castName: String
) {

    Card(
        modifier = Modifier
            .padding(start = 4.dp, end = 4.dp)
            .width(100.dp),
        shape = RoundedCornerShape(CARD_CORNER_RADIUS),
        backgroundColor = MaterialTheme.colors.cardItemBackgroundColor,
        border = BorderStroke(0.5.dp, MaterialTheme.colors.cardBorderColor),
    ) {


        ConstraintLayout(
            modifier = Modifier
                .padding(4.dp)
                .clip(RoundedCornerShape(CARD_CORNER_RADIUS))
                .fillMaxSize()

        ) {

            val (imageId, castNameId) = createRefs()

            val painter = rememberImagePainter(
                data = imgUrl,
                builder = { }
            )

            Image(
                modifier = Modifier.constrainAs(imageId) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
                painter = painter,
                contentDescription = "Single-Movie-Image",
                contentScale = ContentScale.FillBounds
            )

            Text(
                modifier = Modifier
                    .height(20.dp)
                    .background(colorAlphaForCastText.copy(alpha = 0.8f))
                    .constrainAs(castNameId) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                    },
                text = castName,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.contentTextColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                )

        }

    }
}

@Composable
@Preview
private fun PreviewSingleMovieCastItem() {

//
    SingleMovieCastItem("static.tvmaze.com/uploads/images/medium_portrait/0/1815.jpg", "lol")

}