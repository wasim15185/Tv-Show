package android.example.tv_show.component

  import android.example.tv_show.ui.theme.Tv_showTheme
  import android.example.tv_show.ui.theme.backButtonColor
  import androidx.compose.foundation.background
  import androidx.compose.foundation.border
 import androidx.compose.foundation.layout.fillMaxSize
 import androidx.compose.foundation.layout.padding
 import androidx.compose.foundation.layout.size
 import androidx.compose.foundation.shape.RoundedCornerShape
 import androidx.compose.material.Card
 import androidx.compose.material.Icon
import androidx.compose.material.IconButton
  import androidx.compose.material.MaterialTheme
  import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
 import androidx.compose.ui.draw.clip
 import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun BackArrow(
    size: Dp,
    padding:Dp,
    modifier :Modifier =Modifier ,
    onClick:()->Unit
) {

    Card(

            modifier.size(size)
            .padding(padding) ,

        shape = RoundedCornerShape(100.dp)

    ){
        IconButton(
            modifier = Modifier.fillMaxSize(),
            onClick = onClick,
            ){
            Icon(
                Icons.Filled.ArrowBack,
                "contentDescription",
                tint = MaterialTheme.colors.backButtonColor
            )
        }
    }



}


@Composable
@Preview
private fun PreViewBackArrow(){
    BackArrow(24.dp,0.dp ,onClick = {})
}
@Composable
@Preview
private fun PreViewBackArrowDark(){
    Tv_showTheme(darkTheme = true) {
        BackArrow(24.dp, 0.dp, onClick = {})
    }
}