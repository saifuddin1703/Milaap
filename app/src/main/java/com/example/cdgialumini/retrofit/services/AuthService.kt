package com.example.cdgialumini.retrofit.services

import com.example.cdgialumini.retrofit.requestBodies.auth.LoginRequestBody
import com.example.cdgialumini.retrofit.responseBodies.auth.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/api/auth/v1/login")
    suspend fun login(@Body loginRequestBody: LoginRequestBody) : LoginResponse

}