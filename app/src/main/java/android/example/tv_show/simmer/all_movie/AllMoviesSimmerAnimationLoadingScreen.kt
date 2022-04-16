package android.example.tv_show.simmer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun AllMoviesSimmerAnimationLoadingScreen(){

    LazyColumn {

        /*
          Lay down the Shimmer Animated item 5 time
          [repeat] is like a loop which executes the body
          according to the number specified
        */
        repeat(5) {
            item {
                AllMoviesSimmerAnimation()
            }
        }
    }


}