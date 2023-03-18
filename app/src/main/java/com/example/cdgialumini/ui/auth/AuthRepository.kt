package com.example.cdgialumini.ui.auth

import com.example.cdgialumini.retrofit.requestBodies.auth.LoginRequestBody
import com.example.cdgialumini.retrofit.services.AuthService
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authService: AuthService) {

    companion object{
        var token:String? = null
    }

    suspend fun login(loginRequestBody: LoginRequestBody) = authService.login(loginRequestBody)

}