package com.example.cdgialumini.ui.post.repository

//import com.example.cdgialumini.data.posts
import com.example.cdgialumini.models.Post
import com.example.cdgialumini.retrofit.services.PostService
import com.example.cdgialumini.ui.auth.AuthRepository
import com.example.cdgialumini.utils.Bearer
import javax.inject.Inject

class PostRepository @Inject constructor(private val postService: PostService,private val authRepository: AuthRepository) {

    fun getPostList(): List<Post> {
        return listOf()
    }

    suspend fun getUserFeed() =
        postService.getUserFeed(
            token = Bearer.getBearer(authRepository.getToken()!!),
        )

    suspend fun likePost(postId: String) =
        postService.likePost(
            token = Bearer.getBearer(authRepository.getToken()!!),
            postId = postId
        )

    suspend fun dislikePost(postId: String) =
        postService.dislikePost(
            token = Bearer.getBearer(authRepository.getToken()!!),
            postId = postId
        )

    suspend fun savePost(postId: String) =
        postService.savePost(
            token = Bearer.getBearer(authRepository.getToken()!!),
            postId = postId
        )

    suspend fun unSavePost(postId: String) =
        postService.unSavePost(
            token = Bearer.getBearer(authRepository.getToken()!!),
            postId = postId
        )

    suspend fun getPostById(id : String) = postService.getPostById(
        token = Bearer.getBearer(authRepository.getToken()!!),
        postId = id
    )

}