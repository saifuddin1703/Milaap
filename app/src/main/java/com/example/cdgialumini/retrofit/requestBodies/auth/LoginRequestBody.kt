package com.example.cdgialumini.retrofit.requestBodies.auth

import com.google.gson.annotations.SerializedName

data class LoginRequestBody(
    @SerializedName("email") val email : String? = null,
    @SerializedName("enrollmentId") val enrollmentId : String? = null,
    @SerializedName("password") val password : String = ""
)
