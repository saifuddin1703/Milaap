package com.example.cdgialumini.ui.auth.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cdgialumini.retrofit.requestBodies.auth.LoginRequestBody
import com.example.cdgialumini.retrofit.services.AuthService
import com.example.cdgialumini.ui.auth.AuthRepository
import com.example.cdgialumini.ui.auth.uiState.LoginUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    private val _uiState : MutableLiveData<LoginUIState> by lazy {
        MutableLiveData(LoginUIState(isLoading = false))
    }

    val uiState : LiveData<LoginUIState> = _uiState

    fun setDefault(){
        _uiState.value = LoginUIState(isLoading = false)
    }
    suspend fun login(
        email : String?,
        password : String,
        enrollmentId : String?,
        success:(data : String) -> Unit,
        error:(message : String) -> Unit
    ){
        try {
            val response = authRepository.login(loginRequestBody = LoginRequestBody(email, enrollmentId, password))
            Log.d("TAG",response.token)
            if (response.success) {
//                _uiState.value = LoginUIState(isLoading = false, data = response.token)
                success(response.token)
                Log.d("TOKEN",response.token)
                AuthRepository.token = response.token
            }else
                error(response.message.toString())
//                _uiState.value =  LoginUIState(isLoading = false, message = response.message)

        }catch (e : java.lang.Exception){
            Log.d("ERROR",e.message.toString())
            _uiState.value =  LoginUIState(isLoading = false, message = e.message)
        }
    }
}