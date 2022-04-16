package android.example.tv_show.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFF9C9C9C)
val DarkGray = Color(0xFF141414)


val cardBorderColor_Light=Color(0xFFECEAEA)
val cardBorderColor_Dark=Color(0xFF454545)



// Card Background Color

val cardBackgroundDark = Color(0xFF212121)

val cardBackgroundLight = Color(0xFFFFFFFF)

val colorAlphaForCastText = Color(0xFF181818)



// All Movie Screen Background Color


val allMovieScreenBackgroundLight=Color(0xFFFFFFFF)
val allMovieScreenBackgroundDark=Color(0xFF141414)


val Colors.backButtonColor:Color
    @Composable
    get() =   if (isLight) Color.Black else Color.White


val Colors.contentTextColor: Color
    @Composable // If you will not write '@Composable' it will work .
    get() = if (isLight) DarkGray else LightGray


val Colors.cardBorderColor:Color
@Composable
get() = if (isLight) cardBorderColor_Light else cardBorderColor_Dark



val Colors.cardItemBackgroundColor:Color
    @Composable
    get() = if (isLight) cardBackgroundLight else cardBackgroundDark

//val Colors.allMovieScreenBackgroundColor
//@Composable
//get() = if (isLight) allMovieScreenBackgroundLight else allMovieScreenBackgroundDark

val Colors.shimmerColor:Color
@Composable
get() = if (isLight) Color.LightGray else Color.DarkGray

fun ShimmerColorShades (color: Color) = listOf(
    color.copy(0.9f),
    color.copy(0.2f),
    color.copy(0.9f)

)