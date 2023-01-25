package com.example.cdgialumini.ui.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cdgialumini.R
import com.example.cdgialumini.ui.home.Post
import com.example.cdgialumini.ui.theme.AppGrayLight
import com.example.cdgialumini.ui.theme.AppThemeColor

@Composable
fun PostDetailPage(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        Post({},{},{},{})

        Box(modifier = Modifier.fillMaxWidth()){
            Text(text = "Comments",
            modifier = Modifier
                .align(alignment = Alignment.CenterStart)
                .padding(top = 5.dp, bottom = 5.dp, start = 15.dp),
            fontWeight = FontWeight(500),
                fontSize = 20.sp
            )
        }

        Box{
            LazyColumn(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
                    .align(alignment = TopCenter)
                    .wrapContentHeight()
            ) {
                items(5) {
                    CommentBox()
                }
            }

            PostCommentBox(modifier = Modifier
                .fillMaxWidth()
                .align(alignment = BottomCenter)
                .background(color = Color.White)){

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostCommentBox(modifier: Modifier,onPost : (comment : String)->Unit){
    Box(modifier = modifier
        ){
        Row(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()) {

            Image(painter = painterResource(id = R.drawable.profile_icon)
                , contentDescription = "Profile icon",
            modifier = Modifier
                .size(56.dp)
                .clip(shape = RoundedCornerShape(50)))
            
            var comment by remember{
                mutableStateOf("")
            }

            TextField(value = comment, onValueChange ={
                comment = it
            },
            label = {
                Text(text = "Leave your thoughts here",
                fontWeight = FontWeight(400),
                fontSize = 17.sp)
            },
            colors = TextFieldDefaults.textFieldColors(
                disabledIndicatorColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                containerColor = Color.White
            ))

            Text(text = "Post",
            color = AppThemeColor,
            fontWeight = FontWeight(600),
            fontSize = 19.sp,
            modifier = Modifier.align(alignment = CenterVertically)
                .clickable{
                    onPost(comment)
                })

        }
    }
}

@Preview
@Composable
fun PostCommentBoxPreview(){
    PostCommentBox(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)){

    }
}

@Composable
fun CommentBox(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)) {

        Image(painter = painterResource(id = R.drawable.profile_icon),
            contentDescription = "Profile image",
        modifier = Modifier
            .padding(10.dp)
            .size(56.dp)
            .clip(shape = RoundedCornerShape(50)))

        Column(modifier = Modifier
            .padding(top = 10.dp, bottom = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .background(color = AppGrayLight, shape = RoundedCornerShape(9.dp))) {

            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = "Profile name",
                    fontWeight = FontWeight(700),
                    fontSize = 16.sp
                )
                
                Text(text = "Student",
                    fontWeight = FontWeight(300),
                    fontSize = 15.sp
                )
                
                Text(text = "1 min ago",
                    fontWeight = FontWeight(300),
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(text = "Thanks for sharing",
                    fontWeight = FontWeight(400),
                    fontSize = 15.sp
                )
            }
            
        }
    }
}

@Preview
@Composable
fun CommentBoxPreview(){
    CommentBox()
}

@Preview
@Composable
fun PostDetailPreview(){
    PostDetailPage()
}