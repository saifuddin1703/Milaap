package com.example.cdgialumini.retrofit.requestBodies.auth
import com.google.gson.annotations.SerializedName

data class SetPasswordRequestBody(
    @SerializedName("email")
    val email: String = "",

    @SerializedName("sessionId")
    val sessionId: String = "",

    @SerializedName("otp")
    val otp: String = "",

    @SerializedName("password")
    val password: String = ""
)

