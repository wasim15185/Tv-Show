package android.example.tv_show.ui.viewmodel

import android.example.tv_show.data.models.TvShow
import android.example.tv_show.ui.repository.AllMovieScreenRepository
import android.example.tv_show.utils.ResponseState
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllMovieScreenViewModel @Inject constructor(private val repository: AllMovieScreenRepository) :
    ViewModel() {

    private val TAG = this::class.java.simpleName


    private val _responseState = MutableStateFlow<ResponseState<List<TvShow>>>(ResponseState.Idle)
    val responseState: StateFlow<ResponseState<List<TvShow>>>
        get() = _responseState


    fun fetchAllTvShow() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _responseState.value = ResponseState.Loading
                val list = repository.getAllTvShow()
                _responseState.value = ResponseState.Success(list)

            } catch (e: Exception) {
                Log.d(TAG, e.message!!)
                _responseState.value = ResponseState.Failed(e)
            }


        }
    }

}