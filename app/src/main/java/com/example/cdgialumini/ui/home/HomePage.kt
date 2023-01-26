package com.example.cdgialumini.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cdgialumini.R
import com.example.cdgialumini.data.posts
import com.example.cdgialumini.data.users
import com.example.cdgialumini.models.Post
import com.example.cdgialumini.ui.components.ExpandableText
import com.example.cdgialumini.ui.theme.AppGray
import com.example.cdgialumini.ui.utils.PostActions

@Composable
fun HomePage(parentNavController: NavHostController){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = AppGray)) {

        LazyColumn(){
            items(6){index->
                Post(
                    posts[index],
                    onLike = {

                    },
                    onComment = {

                    },
                    onShare = {

                    },
                    onSave = {

                    },
                    onClick = {
                        parentNavController.navigate("postDetailPage/$index")
                    }
                )
            }
        }
    }
}

@Composable
fun Post(
    post: Post,
    onLike : ()->Unit,
    onComment : ()->Unit,
    onShare : ()->Unit,
    onSave : ()->Unit,
    onClick : () -> Unit = {}
){
    val user = users[post.postedBy.toInt()]
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
            .height(76.dp)) {

            Image(painter = painterResource(id = R.drawable.noun_profile_5178761),
                contentDescription = "profile icon",
            modifier = Modifier
                .size(56.dp)
                .padding(start = 10.dp)
                .align(alignment = CenterVertically)
            )

            Column(modifier = Modifier
                .padding(top = 5.dp,start = 8.dp)
            ) {
                Text(
                    text = user.username,
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
                    text = "1 min ago",
                    color = Color.Black,
                    fontWeight = FontWeight(300),
                    fontSize = 15.sp,
                )
            }
        }

        // Post details
        ExpandableText(
            text = post.description,
            minimizedMaxLines = 3,
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp,end = 10.dp),
            fontWeight = FontWeight(400),
            fontSize = 17.sp
        )

        Image(painter = painterResource(id = R.drawable.post_image),
            contentDescription = "Post Image",
            modifier = Modifier
                .align(alignment = CenterHorizontally)
                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
            contentScale = ContentScale.Fit
        )

        val likeCount = post.likedBy.size
        val commentCount = post.comments.size
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)){

            Text(text = "$likeCount ${if(likeCount > 1) "likes" else "like"}",
                fontSize = 17.sp,
                fontWeight = FontWeight(300),
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(alignment = CenterStart)
            )

            Text(text = "$commentCount ${if(commentCount > 1) "likes" else "like"}",
                fontSize = 17.sp,
                fontWeight = FontWeight(300),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .align(alignment = CenterEnd)
            )
        }


        val postAction = listOf(
            PostActions.Like,
            PostActions.Comment,
            PostActions.Share,
            PostActions.Save,

        )
        Row(modifier = Modifier
            .height(73.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            postAction.forEachIndexed { index, postActions ->


                PostActions(name = postActions.name, icon = postActions.icon,
                    modifier = Modifier
                        .weight(1f)
//                        .padding(start = 20.dp)
                        .align(alignment = CenterVertically)
                        .clickable {
//
                            when (index) {
                                0 -> {
                                    onLike()
                                }
                                1 -> {
                                    onComment()
                                }
                                2 -> {
                                    onShare()
                                }
                                3 -> {
                                    onSave()
                                }
                            }
                        })
            }
        }
    }
}

@Composable
fun PostActions(name : String, icon : Int,modifier: Modifier){
    Column(modifier = modifier) {
        Image(painter = painterResource(icon),
            contentDescription = "Action Icon",
            modifier = Modifier
                .align(alignment = CenterHorizontally)
                .size(28.dp)
        )
        Text(text = name,
            fontSize = 15.sp,
            fontWeight = FontWeight(300),
            modifier = Modifier
                .align(alignment = CenterHorizontally)
        )
    }
}

@Preview
@Composable
fun ActionPreview(){
    PostActions(name = "Like", icon = R.drawable.noun_like_1027080, modifier = Modifier.width(30.dp))
}
@Preview
@Composable
fun HomePagePreview(){
    HomePage(rememberNavController())
}

@Preview
@Composable
fun PostPreview(){
    Post(posts[0],{},{},{},{})
}