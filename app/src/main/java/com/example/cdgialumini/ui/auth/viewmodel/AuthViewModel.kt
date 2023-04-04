package com.example.cdgialumini.ui.auth.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cdgialumini.retrofit.requestBodies.auth.LoginRequestBody
import com.example.cdgialumini.retrofit.requestBodies.auth.SetPasswordRequestBody
import com.example.cdgialumini.retrofit.requestBodies.auth.SignupRequestBody
import com.example.cdgialumini.ui.auth.AuthRepository
import com.example.cdgialumini.ui.auth.uiState.LoginUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    private val _uiState : MutableLiveData<LoginUIState> by lazy {
        MutableLiveData(LoginUIState(isLoading = false))
    }


    suspend fun isLoggedIn() = authRepository.isLoggedIn()

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
            Log.d("TAG",response.toString())
            if (response.success) {
                authRepository.setToken(response.data?.token!!)
                Log.d("DEBUG",response.data.toString())
                response.data.token.let { success(it) }
            }else
                error(response.message.toString())
//                _uiState.value =  LoginUIState(isLoading = false, message = response.message)

        }catch (e : java.lang.Exception){
            error(e.message.toString())
            Log.d("ERROR",e.message.toString())
            _uiState.value =  LoginUIState(isLoading = false, message = e.message)
        }
    }

    suspend fun signup(
        name : String,
        email : String,
        enrollmentId : String,
        success:(sessionId : String) -> Unit,
        error:(message : String) -> Unit
    ){
        try {
            val response = authRepository.signup(signupRequestBody = SignupRequestBody(name = name,email = email, enrollmentId = enrollmentId))
            Log.d("TAG",response.toString())
            if (response.success) {
                Log.d("DEBUG",response.data.toString())
                response.data.sessionId.let { success(it) }
            }else
                error(response.message.toString())
//                _uiState.value =  LoginUIState(isLoading = false, message = response.message)

        }catch (e : java.lang.Exception){
            error(e.message.toString())
            Log.d("ERROR",e.message.toString())
            _uiState.value =  LoginUIState(isLoading = false, message = e.message)
        }
    }

    suspend fun setPassword(
        email : String,
        password : String,
        sessionId : String,
        success:(token : String) -> Unit,
        error:(message : String) -> Unit
    ){
        try {
            val response = authRepository.setPassword(setPasswordRequestBody = SetPasswordRequestBody(email = email, sessionId = sessionId, password = password))
            Log.d("TAG",response.toString())
            if (response.success) {
                authRepository.setToken(response.data.token)
                Log.d("DEBUG",response.data.toString())
                response.data.token.let { success(it) }
            }else
                error(response.message.toString())
//                _uiState.value =  LoginUIState(isLoading = false, message = response.message)

        }catch (e : java.lang.Exception){
            error(e.message.toString())
            Log.d("ERROR",e.message.toString())
            _uiState.value =  LoginUIState(isLoading = false, message = e.message)
        }
    }
}