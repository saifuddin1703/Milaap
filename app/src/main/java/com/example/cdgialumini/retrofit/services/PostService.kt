package com.example.cdgialumini.retrofit.services

import com.example.cdgialumini.retrofit.responseBodies.post.PostDetailResponse
import com.example.cdgialumini.retrofit.responseBodies.post.PostResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {

    @GET("api/v1/post/feed")
    suspend fun getUserFeed(@Header("Authorization") token : String,@Query("limit") limit : Int = 10,@Query("page") page : Int = 1) : PostResponse

    @PUT("api/v1/post/{postId}/like")
    suspend fun likePost(@Header("Authorization") token : String,@Path("postId") postId : String)

    @DELETE("api/v1/post/{postId}/like")
    suspend fun dislikePost(@Header("Authorization") token : String,@Path("postId") postId : String)

    @POST("api/v1/post/{postId}/bookmark")
    suspend fun savePost(@Header("Authorization") token : String,@Path("postId") postId : String)

    @DELETE("api/v1/post/{postId}/bookmark")
    suspend fun unSavePost(@Header("Authorization") token : String,@Path("postId") postId : String)

    @GET("api/v1/post/{postId}")
    suspend fun getPostById(@Header("Authorization") token : String,@Path("postId") postId : String) : PostDetailResponse
}