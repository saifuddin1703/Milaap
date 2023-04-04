package com.example.cdgialumini.retrofit.responseBodies.auth

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class LoginResponse(
    @SerializedName("success") val success : Boolean = false,
    @SerializedName("message") val message : String?,
    @SerializedName("data") val data : LoginData?,
)

data class LoginData(
    @SerializedName("token") val token : String = ""
)
