package com.example.cdgialumini.retrofit.responseBodies.auth

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("success") val success : Boolean = true,
    @SerializedName("message") val message : String? = null,
    @SerializedName("token") val token : String = ""
)
