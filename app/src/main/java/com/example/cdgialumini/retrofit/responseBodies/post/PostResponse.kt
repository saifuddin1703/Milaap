package com.example.cdgialumini.retrofit.responseBodies.post

import com.example.cdgialumini.models.Post
import com.example.cdgialumini.retrofit.responseBodies.auth.Data
import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("success") val success : Boolean = false,
    @SerializedName("message") val message : String?,
    @SerializedName("data") val data : com.example.cdgialumini.retrofit.responseBodies.post.Data?,
)

data class Data(
    @SerializedName("posts") val posts : ArrayList<Post> = arrayListOf()
)
