package com.example.cdgialumini.retrofit.responseBodies.post

import com.example.cdgialumini.models.Post
import com.google.gson.annotations.SerializedName

data class PostDetailResponse(
    @SerializedName("success") val success : Boolean = false,
    @SerializedName("message") val message : String?,
    @SerializedName("data") val data : PostData?
)

data class PostData(
    @SerializedName("post") val post : Post = Post()
)

