package com.example.cdgialumini.models

data class User(
    val id : Long = 0,
    val username : String = "",
    val rollNumber : String = "",
    val profileImage : String = "",
    val coverImage : String = "",
    val about : String = "",
    val experiences : List<Experience> = listOf(),
    val educations : List<Education> = listOf(),
    val code : String = "",
    val userType : UserType = UserType.STUDENT,
    val password : String = "12345",
    val tagline : String = "",
    val batch : Number = 2023
)
