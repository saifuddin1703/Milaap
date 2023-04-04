package com.example.cdgialumini.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cdgialumini.models.Post
import com.example.cdgialumini.ui.auth.AuthRepository
import com.example.cdgialumini.ui.auth.uiState.LoginUIState
import com.example.cdgialumini.ui.home.uiState.HomeUIState
import com.example.cdgialumini.ui.post.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

//    suspend fun isLoggedin()

    private val _uiState : MutableLiveData<HomeUIState> by lazy {
        MutableLiveData(HomeUIState(isLoading = false))
    }

    val uiState : LiveData<HomeUIState> = _uiState

    suspend fun getFeed(
//        success : (posts : ArrayList<Post>) -> Unit,
//        error : (message : String) -> Unit
    ){
        try {
            val response = postRepository.getUserFeed()
            if (response.success) {
                _uiState.value = HomeUIState(isLoading = false, data = response.data?.posts)
//                response.data?.posts?.let { success(it) }
            }else {
                _uiState.value = HomeUIState(isLoading = false, message = response.message)
                response.message?.let { error(it) }
            }
            Log.d("TAG",response.toString())
        }catch (e : Exception){
//            error(e.message.toString())
            _uiState.value = HomeUIState(isLoading = false, message = e.message)
            Log.d("TAG",e.message.toString())
        }
    }
}