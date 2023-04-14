package com.example.cdgialumini.models

import com.google.gson.annotations.SerializedName


data class Post (
    @SerializedName("_id") var Id : String? = null,
    @SerializedName("user") var user : String? = null,
    @SerializedName("text") var text : String? = null,
    @SerializedName("images") var images : ArrayList<String> = arrayListOf(),
    @SerializedName("createdAt") var createdAt : String? = null,
    @SerializedName("updatedAt") var updatedAt : String? = null,
    @SerializedName("like") var like : Like? = Like(),
    @SerializedName("comment") var comment : Comment? = Comment(),
    @SerializedName("owner") var owner : Owner? = Owner(),
    @SerializedName("bookmark") var bookmark : Bookmark? = Bookmark()
)

data class Owner (
    @SerializedName("entity" ) var entity : User? = User()
)
data class Like (
    @SerializedName("count"   ) var count   : Int?     = 0,
    @SerializedName("isLiked" ) var isLiked : Boolean? = false
)


data class Comment (
    @SerializedName("count" ) var count : Int? = 0
)

data class Bookmark (
    @SerializedName("isBookmarked" ) var isBookmarked : Boolean? = false
)