package com.example.cdgialumini.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopEnd
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
import com.example.cdgialumini.data.currentUser

@Composable
fun TopAppBar(title : String){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .background(color = Color.White))
    {
        Row(modifier = Modifier.align(alignment = CenterStart)){

            AsyncImage(
                model = currentUser.profileImage,
                placeholder = painterResource(id = R.drawable.noun_profile_5178761),
                contentDescription = "Profile",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(50.dp)
                    .clip(shape = CircleShape)
                    .align(alignment = CenterVertically)
                    ,
                contentScale = ContentScale.Crop,
            )

            Text(
                text = title,
                modifier = Modifier
                    .align(alignment = CenterVertically)
                    .padding(start = 10.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Row(modifier = Modifier
            .align(alignment = CenterEnd)) {

            Image(painter = painterResource(id = R.drawable.search_icon),
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(30.dp)
                    .align(alignment = CenterVertically)
                    )

            Box(
                modifier = Modifier
                    .padding(end = 10.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.notification_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                )
                Box(modifier = Modifier
                    .size(10.dp)
                    .background(color = Color.Red, shape = CircleShape)
                    .align(alignment = TopEnd))

            }
        }
    }
}

@Preview
@Composable
fun TopAppBarPreview(){
    TopAppBar("Home")
}