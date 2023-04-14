package com.example.cdgialumini.ui.post

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cdgialumini.R
import com.example.cdgialumini.data.posts
import com.example.cdgialumini.data.users
import com.example.cdgialumini.models.Post
import com.example.cdgialumini.ui.components.ExpandableText
import com.example.cdgialumini.utils.DateUtility

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Post(
    post: Post,
    onLike : ()->Unit,
    onDislike : ()->Unit,
    onComment : ()->Unit,
    onShare : ()->Unit,
    onSave : ()->Unit,
    onUnSave : ()->Unit,
    onClick : () -> Unit = {},
    onProfileClick : (id : Long)-> Unit = {}
){
    val user = users[0]
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 10.dp)
//        .height(464.dp)
        .background(color = Color.White)
        .clickable {
            onClick()
        }
    ) {

        // Profile Details
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
            .clickable {
                onProfileClick(user.id)
            }) {

            AsyncImage(
                model = user.profileImage,
                placeholder = painterResource(id = R.drawable.noun_profile_5178761),
                contentDescription = "profile icon",
                modifier = Modifier
//                .height()
                    .size(56.dp)
                    .padding(start = 10.dp)
                    .align(alignment = Alignment.CenterVertically)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier
                .padding(top = 5.dp,start = 8.dp)
            ) {
                Text(
                    text = user.email,
                    color = Color.Black,
                    fontWeight = FontWeight(700),
                    fontSize = 16.sp,
                )

                Text(
                    text = user.userType.toString(),
                    color = Color.Black,
                    fontWeight = FontWeight(300),
                    fontSize = 15.sp,

                    )

                Text(
                    text = DateUtility.getTimeAgo(post.createdAt!!),
                    color = Color.Black,
                    fontWeight = FontWeight(300),
                    fontSize = 15.sp,
                )
            }
        }

        // Post details
        post.text?.let {
            ExpandableText(
                text = it,
                minimizedMaxLines = 3,
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp,end = 10.dp),
                fontWeight = FontWeight(400),
                fontSize = 17.sp
            )
        }

        Log.d("Post", "Post: ${post.images}")
        AsyncImage(
            model = if(post.images.isEmpty()) "" else post.images[0],
            placeholder = painterResource(id = R.drawable.post_image),
            contentDescription = "Post Image",
            modifier = Modifier
//                .height(300.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
            contentScale = ContentScale.Fit,

            )

        var likeCount = post.like?.count!!
        val commentCount = post.comment?.count!!
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)){

            Text(text = "$likeCount ${if(likeCount > 1) "likes" else "like"}",
                fontSize = 17.sp,
                fontWeight = FontWeight(300),
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(alignment = Alignment.CenterStart)
                    .clickable {
                        // go to like list page
                    }
            )

            Text(text = "$commentCount ${if(commentCount > 1) "comments" else "comment"}",
                fontSize = 17.sp,
                fontWeight = FontWeight(300),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .align(alignment = Alignment.CenterEnd)
                    .clickable {
                        //
                        // go to post detail page
                    }
            )
        }


        val postAction = listOf(
            com.example.cdgialumini.ui.utils.PostActions.Like,
            com.example.cdgialumini.ui.utils.PostActions.Comment,
            com.example.cdgialumini.ui.utils.PostActions.Share,
            com.example.cdgialumini.ui.utils.PostActions.Save,

            )
        Row(modifier = Modifier
            .height(73.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            postAction.forEachIndexed { index, postActions ->


                var icon by remember {
                    mutableStateOf(postActions.icon)
                }

                var clickFunc = {}

                when (index) {
                    0 -> {
                        icon = if (post.like!!.isLiked == true) {
                            R.drawable.liked
                        } else {
                            R.drawable.noun_like_1027080
                        }
                        clickFunc = {
                            if (post.like!!.isLiked == true) {
                                //dislike
                                icon = R.drawable.noun_like_1027080
                                post.like!!.isLiked = false
                                likeCount--
                                onDislike()
                            } else {
                                //like
                                icon = R.drawable.liked
                                post.like!!.isLiked = true
                                likeCount++
                                onLike()
                            }
                        }
                    }

                    1 -> {
                        clickFunc = onComment
                    }

                    2 -> {
                        clickFunc = onShare
                    }

                    3 -> {
                        icon = if (post.bookmark!!.isBookmarked == true) {
                            R.drawable.bookmarked
                        } else {
                            R.drawable.save
                        }
                        clickFunc = {
                            if (post.bookmark!!.isBookmarked == true) {
                                icon = R.drawable.save
                                post.bookmark!!.isBookmarked = false
                                onUnSave()
                            } else {
                                icon = R.drawable.bookmarked
                                post.bookmark!!.isBookmarked = true
                                onSave()
                            }
                        }
                    }
                }

                PostActions(name = postActions.name, icon = icon,
                    modifier = Modifier
                        .weight(1f)
//                        .padding(start = 20.dp)
                        .align(alignment = Alignment.CenterVertically)
                        .clickable {
                            clickFunc()
                        })
            }
        }
    }
}

@Composable
fun PostActions(
    name : String,
    icon : Int,
    modifier: Modifier
){
    Column(
        modifier = modifier
    ) {
        Image(painter = painterResource(icon),
            contentDescription = "Action Icon",
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .size(28.dp)
        )
        Text(text = name,
            fontSize = 15.sp,
            fontWeight = FontWeight(300),
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
fun ActionPreview(){
    PostActions(name = "Like", icon = R.drawable.noun_like_1027080, modifier = Modifier.width(30.dp))
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PostPreview(){
    LazyColumn(){
        items(posts){ post->
            Post(
                post,
                onLike = {

                },
                onDislike = {

                },
                onComment = {

                },
                onShare = {

                },
                onSave = {

                },
                onUnSave = {

                },
                onClick = {
//                            parentNavController.navigate("postDetailPage/$index")
                },
                onProfileClick = {id->
//                    parentNavController.navigate("profile/${id}")
                }
            )
        }
    }
//    Post(posts[0],{},{},{},{})
}