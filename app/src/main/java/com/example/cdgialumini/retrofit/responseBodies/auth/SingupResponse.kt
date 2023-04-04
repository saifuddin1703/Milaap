package com.example.cdgialumini.retrofit.responseBodies.auth

import com.google.gson.annotations.SerializedName

data class SignupResponse(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("data")
    val data: SignupData,

    @SerializedName("message") val message : String?
)

data class SignupData(
    @SerializedName("id")
    val id: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("sessionId")
    val sessionId: String
)
