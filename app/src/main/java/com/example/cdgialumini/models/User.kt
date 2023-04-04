package com.example.cdgialumini.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Long = 0,

    @SerializedName("email")
    val email: String = "",

    @SerializedName("username")
    val username: String = "",

    @SerializedName("rollNumber")
    val rollNumber: String = "",

    @SerializedName("profileImage")
    val profileImage: String = "",

    @SerializedName("coverImage")
    val coverImage: String = "",

    @SerializedName("about")
    val about: String = "",

    @SerializedName("experiences")
    val experiences: List<Experience> = listOf(),

    @SerializedName("educations")
    val educations: List<Education> = listOf(),

    @SerializedName("code")
    val code: String = "",

    @SerializedName("userType")
    val userType: UserType = UserType.STUDENT,

    @SerializedName("password")
    val password: String = "12345",

    @SerializedName("tagline")
    val tagline: String = "",

    @SerializedName("batch")
    val batch: Number = 2023
)

