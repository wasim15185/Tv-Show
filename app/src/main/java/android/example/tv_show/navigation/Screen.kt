package android.example.tv_show.navigation

import android.example.tv_show.utils.NavRouteHolder
import androidx.navigation.NavHostController

class Screen(navController: NavHostController) {

//    val list: (Actions) -> Unit = { action ->
//        navController.navigate("list/${action.name}") {
//            popUpTo(route=LIST_SCREEN) { inclusive = true }
//        }
//    }
//
//    val task:(Int)->Unit ={ taskId ->
//        navController.navigate("task/${taskId}")
//    }




    val singleMovie : (Int)->Unit={ show_Id ->
        navController.navigate("movie/${show_Id}")
    }

    val allMovie:()->Unit={
        navController.navigate("allMovie"){
            popUpTo(route=NavRouteHolder.AllMovie.route) { inclusive = true }
        }
    }

}