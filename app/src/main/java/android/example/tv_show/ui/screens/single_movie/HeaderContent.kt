package android.example.tv_show.ui.screens.single_movie

import android.example.tv_show.component.BackArrow
import android.example.tv_show.ui.theme.LightGray
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import com.gowtham.ratingbar.StepSize

@OptIn(ExperimentalCoilApi::class)
@Composable
fun HeaderContent(
    url: String,
    title: String,
    rating: Double,
    height: Dp,
    genres: List<String>,
    navigateToAllMovieScreen: () -> Unit,
) {

    val painter = rememberImagePainter(data = url, builder = {})

    var _rating: Float by remember { mutableStateOf(rating.toFloat()) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)

    ) {

        Image(
            modifier = Modifier
                .fillMaxSize()
                .drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = size.height / 2,
                        endY = size.height
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(gradient, blendMode = BlendMode.Multiply)
                    }
                },
            painter = painter,
            contentDescription = "Image",
            contentScale = ContentScale.Crop
        )

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {

            val (backButton, mainImg, information) = createRefs() // This 'createRefs()' actually create ids

            val imageStartLineGuideline = createGuidelineFromStart(0.03f)
            val imageBottomLineGuideline = createGuidelineFromBottom(0.03f)

            val backArrowStartGuideline = createGuidelineFromStart(0.03f)
            val backArrowTopGuideline = createGuidelineFromTop(0.03f)

            BackArrow(
                36.dp,
                0.dp,
                modifier = Modifier
                    .constrainAs(backButton) {
                    start.linkTo(backArrowStartGuideline)
                    top.linkTo(backArrowTopGuideline)
                },
                onClick = {
                    navigateToAllMovieScreen()
                }
            )

            Image(
                modifier = Modifier
                    .height(150.dp)
                    .width(100.dp)
                    .constrainAs(mainImg) {
//                        bottom.linkTo(parent.bottom)
//                        start.linkTo(parent.start)
                        start.linkTo(imageStartLineGuideline)
                        bottom.linkTo(imageBottomLineGuideline)
                    },
                painter = painter,
                contentDescription = "Main Image"
            )


            Column(
                modifier = Modifier
                    .height(200.dp)
                    .padding(start = 0.dp)
                    .constrainAs(information) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(mainImg.end)

                        width = Dimension.fillToConstraints
                    },

//                horizontalAlignment = Alignment.CenterHorizontally ,
                verticalArrangement = Arrangement.Center

            ) {

                Text(
                    modifier = Modifier.padding(start = 8.dp, end = 4.dp),
                    text = title,
                    color = LightGray,
                    maxLines = 3,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h5,

                    )

                Row(
                    modifier = Modifier
                        .padding(start = 8.dp, top = 8.dp)
                        .fillMaxWidth()
                ) {
                    genres.forEachIndexed { index, text ->
                        Text(
                            text = "$text ${addComma(genres.size, index)}",
                            color = LightGray,
                            style = MaterialTheme.typography.subtitle2,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                }


                RatingBar(
                    modifier = Modifier
                        .padding(start = 8.dp, top = 12.dp),
                    value = _rating,
                    config = ratingbarConfig(_rating.toInt())
                        .style(RatingBarStyle.HighLighted),

                    onValueChange = {
                        _rating = it
                    },
                    onRatingChanged = {}
                )


            }


        }


    }

}


fun addComma(arrSize: Int, currentArrIndex: Int): String {

    return if ((arrSize - 1) != currentArrIndex) " , " else ""

}


fun ratingbarConfig(numberOfStarts: Int) = RatingBarConfig()
    .activeColor(Color.Yellow)
    .hideInactiveStars(true)
    .inactiveColor(Color.LightGray)
    .stepSize(StepSize.HALF)
    .numStars(numberOfStarts)
    .isIndicator(true)
    .size(16.dp)
    .padding(3.dp)
    .style(RatingBarStyle.HighLighted)


