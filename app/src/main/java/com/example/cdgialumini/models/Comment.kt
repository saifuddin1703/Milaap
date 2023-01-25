package com.example.cdgialumini.models

data class Comment(
    val _id : Long = 0,
    val comment : String = "",
    val commentedBy : Long = 0,
    val commentAt : Long = 0L
)
