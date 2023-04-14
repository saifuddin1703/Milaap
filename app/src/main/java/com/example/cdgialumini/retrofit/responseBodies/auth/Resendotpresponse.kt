package com.example.cdgialumini.retrofit.responseBodies.auth

import com.google.gson.annotations.SerializedName

data class Resendotpresponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String
)
