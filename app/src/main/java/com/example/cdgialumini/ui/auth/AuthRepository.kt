package com.example.cdgialumini.ui.auth

import android.content.Context
import android.util.Log
import com.example.cdgialumini.retrofit.requestBodies.auth.LoginRequestBody
import com.example.cdgialumini.retrofit.requestBodies.auth.SetPasswordRequestBody
import com.example.cdgialumini.retrofit.requestBodies.auth.SignupRequestBody
import com.example.cdgialumini.retrofit.services.AuthService
import com.example.cdgialumini.utils.DEFAUlT
import com.example.cdgialumini.utils.SHARED_PREF_KEY
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authService: AuthService,
    @ApplicationContext private val context: Context
    ) {

    fun setToken(token : String){
        val sharedPref =  context.getSharedPreferences("TokenRegister",Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putString(SHARED_PREF_KEY, token)
            apply()
        }
    }

    fun getToken(): String? {
        val sharedPref =  context.getSharedPreferences("TokenRegister",Context.MODE_PRIVATE)

        return sharedPref.getString(SHARED_PREF_KEY,DEFAUlT)
    }

    suspend fun login(loginRequestBody: LoginRequestBody) = authService.login(loginRequestBody)

    suspend fun signup(signupRequestBody: SignupRequestBody) = authService.signup(signupRequestBody)

    suspend fun setPassword(setPasswordRequestBody: SetPasswordRequestBody) = authService.setPassword(setPasswordRequestBody)

    suspend fun isLoggedIn(): Boolean {
        val token = getToken()

        Log.d("DEBUG",token.toString())
        if (token == null || token == DEFAUlT) throw Exception("Not a valid token")

        val response = authService.validate_token("Bearer $token")

        if (!response.success) throw Exception("Not a valid token")

        return true
    }
}