package android.example.tv_show.utils

sealed class NavRouteHolder(val route: String) {

    object SingleMovie : NavRouteHolder("movie/{showId}") {
        private const val SINGLE_MOVIE_ARGUMENT_KEY = "showId"
        fun getArgument_key() = SINGLE_MOVIE_ARGUMENT_KEY
    }

    object AllMovie : NavRouteHolder("allMovie")


}
