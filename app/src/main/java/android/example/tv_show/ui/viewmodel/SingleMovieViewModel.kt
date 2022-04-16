package android.example.tv_show.ui.viewmodel

import android.example.tv_show.data.models.ShowCast
import android.example.tv_show.data.models.TvShow
import android.example.tv_show.ui.repository.AllMovieScreenRepository
import android.example.tv_show.utils.ResponseState
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleMovieViewModel @Inject constructor(private val repository: AllMovieScreenRepository) :
    ViewModel() {

    private val TAG = this::class.java.simpleName

    private val _responseState = MutableStateFlow<ResponseState<TvShow>>(ResponseState.Idle)
    val responseState: StateFlow<ResponseState<TvShow>>
        get() = _responseState


    private val _castResponseState = MutableStateFlow<ResponseState<List<ShowCast>>>(ResponseState.Idle)
    val castResponseState: StateFlow<ResponseState<List<ShowCast>>>
        get() = _castResponseState


    fun fetchTvShow(showId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _responseState.value = ResponseState.Loading
                val list = repository.getShow(showId)
                _responseState.value = ResponseState.Success(list)

            } catch (e: Exception) {
                Log.d(TAG, e.message!!)
                _responseState.value = ResponseState.Failed(e)
            }


        }
    }


    fun fetchShowCast(showId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _castResponseState.value = ResponseState.Loading
                val castDetailList = repository.getAllCasts(showId)
                _castResponseState.value = ResponseState.Success(castDetailList)

            } catch (e: Exception) {
                Log.d(TAG, e.message!!)
                _castResponseState.value = ResponseState.Failed(e)
            }


        }
    }


}