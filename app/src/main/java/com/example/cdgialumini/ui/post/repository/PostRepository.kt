package com.example.cdgialumini.ui.post.repository

import com.example.cdgialumini.data.posts
import com.example.cdgialumini.models.Post

class PostRepository {

    fun getPostList(): List<Post> {
        return posts
    }

    fun getPostById(id : Long): Post? {
        posts.forEach {
            if(it._id == id) return it
        }

        return null
    }

}