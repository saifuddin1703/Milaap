package com.example.cdgialumini.ui.messenging

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.cdgialumini.R
import com.example.cdgialumini.data.currentUser
import com.example.cdgialumini.data.users
import com.example.cdgialumini.models.User

@Composable
fun MessagesPage(){

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)){
        items(users){
            MessageBox(user = it)
        }
    }
}

@Composable
fun MessageBox(user: User){
        val name = user.username
        val type = user.userType.name
        val message = "This is the last message"

        Box(modifier = Modifier
            .height(76.dp)
            .fillMaxWidth()
            .background(color = Color.White)){

            Row(modifier = Modifier
                .padding(13.dp)
                .align(alignment = Alignment.CenterStart)) {

                // Profile picture
                Image(painter = painterResource(id = R.drawable.dp)
                    , contentDescription = "ProfileImage",
                    modifier = Modifier
                        .height(56.dp)
                        .width(50.dp)
                        .clip(shape = RoundedCornerShape(50))
                        .align(alignment = Alignment.CenterVertically),
                    contentScale = ContentScale.Crop
                )

                Column {
//                    Row {
//
//                        Canvas(modifier = Modifier
//                            .padding(10.dp)
//                            .align(Alignment.CenterVertically)) {
//                            drawCircle(color = Color.Gray, radius = 4.dp.toPx())
//                        }
//
//                        Text(
//                            text = type,
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight(500),
//                            color = Color.LightGray
//                        )
//                    }

                    Text(
                        text = name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700),
                        modifier = Modifier.padding(start = 10.dp)
                    )

                    Text(
                        text = message,
                        fontSize = 19.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }
        }

}

@Preview
@Composable
fun MessageBoxPreview(){
    MessageBox(user = currentUser)
}
@Preview
@Composable
fun MessagesPreview(){
    MessagesPage()
}