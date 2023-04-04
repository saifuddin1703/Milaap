package com.example.cdgialumini.retrofit.services

import com.example.cdgialumini.retrofit.responseBodies.post.PostResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PostService {

    @GET("api/v1/post/feed")
    suspend fun getUserFeed(@Header("Authorization") token : String,@Query("limit") limit : Int = 10,@Query("page") page : Int = 1) : PostResponse
}