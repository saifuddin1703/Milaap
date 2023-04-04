package com.example.cdgialumini.retrofit.responseBodies

import com.google.gson.annotations.SerializedName

data class ResponseBody(
    @SerializedName("success") val success : Boolean = true,
    @SerializedName("message") val message : String? = null,
    @SerializedName("status") val status : String = ""
)
