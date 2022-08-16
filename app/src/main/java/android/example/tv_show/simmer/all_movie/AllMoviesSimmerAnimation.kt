package android.example.tv_show.simmer.all_movie

import android.example.tv_show.ui.theme.*
import androidx.compose.animation.core.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AllMoviesSimmerAnimation(){



        /*
        Create InfiniteTransition
        which holds child animation like [Transition]
        animations start running as soon as they enter
        the composition and do not stop unless they are removed
        */
        val transition = rememberInfiniteTransition()
        val translateAnim by transition.animateFloat(
            /*
            Specify animation positions,
            initial Values 0F means it
            starts from 0 position
            */
            initialValue = 0f,
            targetValue = 1000f,
            animationSpec = infiniteRepeatable(


                // Tween Animates between values over specified [durationMillis]
                tween(durationMillis = 1200, easing = FastOutSlowInEasing),
                RepeatMode.Reverse
            )
        )

        /*
        Create a gradient using the list of colors
        Use Linear Gradient for animating in any direction according to requirement
        start=specifies the position to start with in cartesian like system Offset(10f,10f) means x(10,0) , y(0,10)
        end = Animate the end position to give the shimmer effect using the transition created above
        */
        val brush = Brush.linearGradient(
            colors = ShimmerColorShades(MaterialTheme.colors.shimmerColor),
            start = Offset(10f, 10f),
            end = Offset(translateAnim, translateAnim)
        )

    AllMovieSimmerItem(brush = brush, padding =  5.dp)



}



@Preview
@Composable
private fun PreviewAllMoviesSimmerAnimation(){
    AllMoviesSimmerAnimation()
}