package com.example.cdgialumini.retrofit.responseBodies.auth

import com.example.cdgialumini.models.User
import com.google.gson.annotations.SerializedName

data class SetPasswordResponse(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("message") val message : String?,

    @SerializedName("data")
    val data: Data
)

data class Data(
    @SerializedName("user")
    val user: User,

    @SerializedName("token")
    val token: String
)