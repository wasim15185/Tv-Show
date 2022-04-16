package android.example.tv_show.component

import android.example.tv_show.ui.screens.all_movies.Rating
import android.example.tv_show.ui.screens.all_movies.AllMovieSummery
import android.example.tv_show.ui.theme.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class, ExperimentalMaterialApi::class)
@Composable
fun MovieCard(
    imgUrl: String,
    title: String,
    rating: Double,
    padding: Dp,
    summery: String ,
    onClick:()->Unit

) {

    val painter = rememberImagePainter(
        data = imgUrl,
        builder = {

        }
    )


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
        onClick = onClick
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(3f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.clip(shape = RoundedCornerShape(CARD_CORNER_RADIUS)),
                    painter = painter,
                    contentDescription = "Image",
                )

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(8f),
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = CARD_ITEM_TEXT_PADDING_LEFT)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                            .height(20.dp),
                        text = title,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.contentTextColor,
                        style = MaterialTheme.typography.subtitle1
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Rating(60.dp, rating = rating.toFloat())

                    Spacer(modifier = Modifier.height(7.dp))
                    AllMovieSummery(text = summery)
                }

            }

        }


    }


}


@Composable
@Preview
private fun PreviewMovieCard() {
    MovieCard(
        title = "I am title ",
        imgUrl = "https://images.unsplash.com/photo-1649087445063-8c4783b12ba8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=389&q=80",
        rating = 5.6,
        padding = 5.dp,
        summery = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes" ,
        onClick = {}
    )
}
