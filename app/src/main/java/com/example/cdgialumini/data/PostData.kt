package com.example.cdgialumini.data

import com.example.cdgialumini.models.Comment
import com.example.cdgialumini.models.Post

val posts = listOf(
    Post(
        _id = 0,
        title = "Post Title 1",
        description = "Post description 1",
        imageURL = "",
        likedBy = listOf(0,1,2),
        comments = listOf(
        Comment(
            _id = 0,
            comment = "very good",
            commentedBy = 0,
            commentAt = System.currentTimeMillis())
        )
    ),
    Post(
        _id = 1,
        title = "Post Title 2",
        description = "Post description 2",
        imageURL = "",
        likedBy = listOf(0,1,2),
        comments = listOf(
            Comment(
                _id = 1,
                comment = "very good",
                commentedBy = 0,
                commentAt = System.currentTimeMillis())
        )
    ),
    Post(
        _id = 2,
        title = "Post Title 3",
        description = "Post description 3",
        imageURL = "",
        likedBy = listOf(0,1,2),
        comments = listOf(
            Comment(
                _id = 2,
                comment = "very good",
                commentedBy = 0,
                commentAt = System.currentTimeMillis())
        )
    ),
    Post(
        _id = 3,
        title = "Post Title 4",
        description = "Post description 4",
        imageURL = "",
        likedBy = listOf(0,1,2),
        comments = listOf(
            Comment(
                _id = 3,
                comment = "very good",
                commentedBy = 0,
                commentAt = System.currentTimeMillis())
        )
    ),
    Post(
        _id = 4,
        title = "Post Title 5",
        description = "Post description 5",
        imageURL = "",
        likedBy = listOf(0,1,2),
        comments = listOf(
            Comment(
                _id = 4,
                comment = "very good",
                commentedBy = 0,
                commentAt = System.currentTimeMillis())
        )
    ),
    Post(
        _id = 5,
        title = "Post Title 6",
        description = "Post description 6",
        imageURL = "",
        likedBy = listOf(0,1,2),
        comments = listOf(
            Comment(
                _id = 5,
                comment = "very good",
                commentedBy = 0,
                commentAt = System.currentTimeMillis())
        )
    )
)