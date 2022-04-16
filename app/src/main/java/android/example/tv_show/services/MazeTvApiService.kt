package android.example.tv_show.services

import android.example.tv_show.data.models.ShowCast
import android.example.tv_show.data.models.TvShow
import android.example.tv_show.utils.Constant
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface MazeTvApiService {

    @GET("shows")
    suspend fun getAllTvShows(): List<TvShow>

    @GET("shows/{id}")
    suspend fun getShow(@Path("id") showId :Int) :TvShow

    @GET("shows/{id}/cast")
    suspend fun getAllCast(@Path("id")showId: Int):List<ShowCast>

    companion object {
        fun create(): MazeTvApiService {
            return Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MazeTvApiService::class.java);

        }
    }

}