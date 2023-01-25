package com.example.cdgialumini.ui.directory

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cdgialumini.R
import com.example.cdgialumini.data.alunmies
import com.example.cdgialumini.data.currentUser
import com.example.cdgialumini.data.faculties
import com.example.cdgialumini.data.users
import com.example.cdgialumini.models.User
import com.example.cdgialumini.ui.theme.AppGray
import com.example.cdgialumini.ui.theme.AppThemeColor
import com.example.cdgialumini.ui.theme.TextGray

@Composable
fun DirectoryPage(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(41.dp)
            .background(color = AppGray)
        ){

            Text(text = "Filters",
            fontWeight = FontWeight(500),
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 17.dp)
                    .align(Alignment.CenterStart),
                color = TextGray
            )
            Image(painter = painterResource(id = R.drawable.noun_filter_4604465),
                contentDescription = "filter",
            modifier = Modifier
                .padding(end = 10.dp)
                .size(26.dp)
                .align(Alignment.CenterEnd)

            )
        }


        var selectedIndex by remember{
            mutableStateOf(0)
        }
        val titles = listOf("Alumni", "Faculty", "Students")
        TabRow(
            selectedTabIndex = selectedIndex,
            indicator = {
                TabRowDefaults.Indicator(
                    color = AppThemeColor,
                    modifier = Modifier.tabIndicatorOffset(it[selectedIndex])
                )
            }
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedIndex == index,
                    onClick = { selectedIndex = index },
                    selectedContentColor = AppThemeColor,
                    unselectedContentColor = Color.Black,
                    text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
                )
            }
        }

        when (selectedIndex){
            0->{
                Alumnies()
            }

            1->{
                Faculties()
            }

            2->{
                Students()
            }
        }
    }
}

@Composable
fun Faculties(){
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(faculties){faculty->
            ProfileBox(user = faculty)
        }
    }

}

@Composable
fun Alumnies(){
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(alunmies){ alumni->
            ProfileBox(user = alumni)
        }
    }

}

@Composable
fun Students(){
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(users){ user->
            ProfileBox(user = user)
        }
    }

}
@Composable
fun ProfileBox(user : User){

    val name = user.username
    val type = user.userType.name
    val tagline = user.tagline
    
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
                .align(alignment = CenterVertically),
                contentScale = ContentScale.Crop
            )
            
            Column {
                Row {
                    Text(
                        text = name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                        modifier = Modifier.padding(start = 10.dp)
                    )

                    Canvas(modifier = Modifier
                        .padding(10.dp)
                        .align(CenterVertically)) {
                        drawCircle(color = Color.Gray, radius = 4.dp.toPx())
                    }

                    Text(
                        text = type,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500),
                        color = Color.LightGray
                    )
                }
                Text(
                    text = tagline,
                    fontSize = 15.sp,
                    fontWeight = FontWeight(300),
                    color = Color.Black,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}

@Composable
@Preview
fun ProfileBoxPreview(){
    ProfileBox(currentUser)
}
@Preview
@Composable
fun PagePreview(){
    DirectoryPage()
}