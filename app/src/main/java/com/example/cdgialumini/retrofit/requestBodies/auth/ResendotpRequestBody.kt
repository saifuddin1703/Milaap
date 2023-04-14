package com.example.cdgialumini.retrofit.requestBodies.auth

import com.google.gson.annotations.SerializedName

data class ResendotpRequestBody(
    @SerializedName("email") val email: String,
    @SerializedName("sessionId") val sessionId: String
)

