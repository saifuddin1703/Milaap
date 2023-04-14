package com.example.cdgialumini.retrofit.services

import com.example.cdgialumini.retrofit.requestBodies.auth.LoginRequestBody
import com.example.cdgialumini.retrofit.requestBodies.auth.ResendotpRequestBody
import com.example.cdgialumini.retrofit.requestBodies.auth.SetPasswordRequestBody
import com.example.cdgialumini.retrofit.requestBodies.auth.SignupRequestBody
import com.example.cdgialumini.retrofit.responseBodies.ResponseBody
import com.example.cdgialumini.retrofit.responseBodies.auth.LoginResponse
import com.example.cdgialumini.retrofit.responseBodies.auth.Resendotpresponse
import com.example.cdgialumini.retrofit.responseBodies.auth.SetPasswordResponse
import com.example.cdgialumini.retrofit.responseBodies.auth.SignupResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {

    @POST("/api/auth/v1/login")
    suspend fun login(@Body loginRequestBody: LoginRequestBody) : LoginResponse

    @POST("/api/auth/v1/initiate-signup")
    suspend fun signup(@Body signupRequestBody: SignupRequestBody) : SignupResponse

    @POST("/api/auth/v1/set-password")
    suspend fun setPassword(@Body setPasswordRequestBody: SetPasswordRequestBody) : SetPasswordResponse

    @POST("/api/auth/v1/resend-otp")
    suspend fun resentOTP(@Body resendotpRequestBody: ResendotpRequestBody) : Resendotpresponse

    @POST("/api/auth/v1/validate-token")
    suspend fun validate_token(@Header("Authorization") token : String) : ResponseBody

}