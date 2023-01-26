package com.example.cdgialumini.models

data class Post(
    val _id : Long = 0,
    val title : String = "",
    val description : String = "",
    val imageURL : String = "",
    val likedBy : List<Long> = listOf(),
    val comments : List<Comment> = listOf(),
    val postedBy : Long = 0
)
