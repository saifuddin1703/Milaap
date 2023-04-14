package com.example.cdgialumini.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cdgialumini.models.Post
import com.example.cdgialumini.ui.auth.AuthRepository
import com.example.cdgialumini.ui.auth.uiState.LoginUIState
import com.example.cdgialumini.ui.home.uiState.HomeUIState
import com.example.cdgialumini.ui.home.uiState.PostDetailUIState
import com.example.cdgialumini.ui.post.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {


    private val _uiState : MutableLiveData<HomeUIState> by lazy {
        MutableLiveData(HomeUIState(isLoading = false))
    }

    val uiState : LiveData<HomeUIState> = _uiState

    private val _postUiState : MutableLiveData<PostDetailUIState> by lazy {
        MutableLiveData(PostDetailUIState(isLoading = false))
    }

    val postUiState : LiveData<PostDetailUIState> = _postUiState

    suspend fun likePost(postId: String) {
        try {
            postRepository.likePost(postId)
            Log.d("TAG","Liked successfully")
        }catch (e : Exception){
//            _uiState.value = HomeUIState(isLoading = false, message = e.message)
            Log.d("TAG",e.message.toString())
        }
    }

    suspend fun dislikePost(postId: String) {
        try {
            postRepository.dislikePost(postId)
            Log.d("TAG","Disliked successfully")
        }catch (e : Exception){
//            _uiState.value = HomeUIState(isLoading = false, message = e.message)
            Log.d("TAG",e.message.toString())
        }
    }

    suspend fun savePost(postId: String) {
        try {
            postRepository.savePost(postId)
            Log.d("TAG","Saved successfully")
        }catch (e : Exception){
//            _uiState.value = HomeUIState(isLoading = false, message = e.message)
            Log.d("TAG",e.message.toString())
        }
    }

    suspend fun unSavePost(postId: String) {
        try {
            postRepository.unSavePost(postId)
            Log.d("TAG","Unsaved successfully")
        }catch (e : Exception){
//            _uiState.value = HomeUIState(isLoading = false, message = e.message)
            Log.d("TAG",e.message.toString())
        }
    }


    suspend fun getPostById(id : String) {
        try {
            val response = postRepository.getPostById(id)
            if (response.success) {
                _postUiState.value = PostDetailUIState(isLoading = false, data = response.data?.post)
//                response.data?.posts?.let { success(it) }
            }else {
                _postUiState.value = PostDetailUIState(isLoading = false, message = response.message)
//                response.message?.let { error(it) }
            }
            Log.d("TAG",response.toString())
        }catch (e : Exception){
//            error(e.message.toString())
            _postUiState.value = PostDetailUIState(isLoading = false, message = e.message)
            Log.d("TAG",e.message.toString())
        }
    }

    suspend fun getFeed(){
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