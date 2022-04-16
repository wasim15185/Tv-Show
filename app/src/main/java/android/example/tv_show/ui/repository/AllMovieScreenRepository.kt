package android.example.tv_show.ui.repository

import android.example.tv_show.services.MazeTvApiService
import javax.inject.Inject


class AllMovieScreenRepository @Inject constructor(private val mazeTvApiService: MazeTvApiService) {

  suspend  fun getAllTvShow()=mazeTvApiService.getAllTvShows()

  suspend fun getShow(showId:Int)=mazeTvApiService.getShow(showId)

  suspend fun getAllCasts(showId:Int)=mazeTvApiService.getAllCast(showId)

}