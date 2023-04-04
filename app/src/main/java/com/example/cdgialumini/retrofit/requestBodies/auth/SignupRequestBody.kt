package com.example.cdgialumini.retrofit.requestBodies.auth

import com.google.gson.annotations.SerializedName

data class SignupRequestBody(
    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("enrollmentId")
    val enrollmentId: String
)

