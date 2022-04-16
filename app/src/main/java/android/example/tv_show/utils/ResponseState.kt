package android.example.tv_show.utils

import android.example.tv_show.data.models.TvShow

sealed class ResponseState<out T>{

    object Idle : ResponseState<Nothing>()
    object Loading : ResponseState<Nothing>()
    data class Success <Q>(val result: Q):ResponseState<Q>()
    data class Failed(val throwable: Throwable):ResponseState<Nothing>()

}
