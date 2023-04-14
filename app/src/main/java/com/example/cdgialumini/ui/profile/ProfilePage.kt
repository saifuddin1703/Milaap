package com.example.cdgialumini.ui.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import coil.compose.AsyncImage
import com.example.cdgialumini.R
import com.example.cdgialumini.data.currentUser
import com.example.cdgialumini.models.Education
import com.example.cdgialumini.models.Experience
import com.example.cdgialumini.models.User
import com.example.cdgialumini.ui.components.ExpandableText
import com.example.cdgialumini.ui.theme.AppGray
import com.example.cdgialumini.ui.theme.AppThemeColor
import kotlin.math.exp

//
@Composable
fun ProfilePage(user : User){

    Column(modifier = Modifier
        .verticalScroll(state = rememberScrollState(),enabled = true)
        .fillMaxSize()
        .background(color = AppGray)
        ) {

        PhotoBox(profileImage = user.profileImage, coverImage = user.coverImage)

        NameBox(name = user.email, tagline = user.tagline)

        AboutBox(content = user.about)

        if (user.experiences.isNotEmpty())
            ExperiencesBox(experiences = user.experiences)

        EducationsBox(educations = user.educations)
    }

}

@Composable
fun NameBox(name : String,tagline : String){

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)) {

        Text(text = name,
            modifier = Modifier.padding(top = 5.dp, start = 10.dp),
            fontWeight = FontWeight(500),
            fontSize = 24.sp
        )

        Text(text = tagline,
            modifier = Modifier.padding(start = 10.dp),
            fontWeight = FontWeight(400),
            fontSize = 15.sp
        )

        Button(onClick = { /*TODO*/ }
        , colors = ButtonDefaults.buttonColors(
                containerColor = AppThemeColor
        ),
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp, top = 15.dp, bottom = 10.dp)
                .height(37.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Message",
                fontWeight = FontWeight(700),
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun AboutBox(content : String){

    Column(modifier = Modifier
        .padding(top = 10.dp)
        .fillMaxWidth()
        .background(color = Color.White)) {

        Text(text = "About",
        fontWeight = FontWeight(700),
        fontSize = 20.sp,
        modifier = Modifier.padding(top = 10.dp, start = 10.dp)
        )

        ExpandableText(text = content,
            fontWeight = FontWeight(400),
            fontSize = 17.sp,
            minimizedMaxLines = 3,
            modifier = Modifier.padding(top = 12.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
        )
    }
}

@Composable
fun ExperiencesBox(experiences : List<Experience>){
    Column(modifier = Modifier
        .padding(top = 10.dp)
        .fillMaxWidth()
        .background(color = Color.White)) {

        Text(
            text = "Experience",
            fontWeight = FontWeight(700),
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 10.dp, start = 10.dp)
        )

        Column {
            experiences.forEach{
                ExperienceBox(experience = it)
            }
        }

    }
}

@Composable
fun ExperienceBox(experience: Experience){

    Column(modifier = Modifier
        .padding(top = 10.dp, start = 10.dp, bottom = 10.dp)
        .fillMaxWidth()) {
        Row {
            Image(painter = painterResource(id = R.drawable.bajaj_logo),
                contentDescription = "Company Logo",
            modifier = Modifier
                .padding(top = 10.dp)
                .size(44.dp))
            
            Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)) {
                Text(text = experience.role,
                fontWeight = FontWeight(600),
                fontSize = 15.sp)

                Text(text = experience.companyName + " - "+ experience.type,
                    fontWeight = FontWeight(400),
                    fontSize = 13.sp)

                Text(text = experience.startDate + " - "+ experience.endDate+" - "+experience.duration,
                    fontWeight = FontWeight(300),
                    fontSize = 13.sp)

                Text(text = experience.location,
                    fontWeight = FontWeight(300),
                    fontSize = 13.sp)

                Text(text = experience.description,
                    fontWeight = FontWeight(400),
                    fontSize = 13.sp,
                    modifier = Modifier.padding(top = 15.dp),
                    lineHeight = 16.sp
                )
            }
        }
    }
}

@Composable
fun EducationsBox(educations : List<Education>){
    Column(modifier = Modifier
        .padding(top = 10.dp)
        .fillMaxWidth()
        .background(color = Color.White)) {

        Text(
            text = "Education",
            fontWeight = FontWeight(700),
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 10.dp, start = 10.dp)
        )

        Column {
            educations.forEach{
                EducationBox(education = it)
            }
        }

    }
}

@Composable
fun EducationBox(education: Education){

    Column(modifier = Modifier
        .padding(top = 10.dp, start = 10.dp, bottom = 10.dp)
        .fillMaxWidth()) {
        Row {
            Image(painter = painterResource(id = R.drawable.bajaj_logo),
                contentDescription = "Company Logo",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .size(44.dp))

            Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)) {
                Text(text = education.instituteName,
                    fontWeight = FontWeight(600),
                    fontSize = 15.sp,
                    lineHeight = 18.sp
                )

                Text(text = education.courseName,
                    fontWeight = FontWeight(400),
                    fontSize = 13.sp,
                    lineHeight = 16.sp
                )

                Text(text = education.startDate + " - "+ education.endDate+" - ",
                    fontWeight = FontWeight(300),
                    fontSize = 13.sp)

            }
        }
    }
}

@Composable
fun PhotoBox(profileImage : String,coverImage : String){

    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)){

        AsyncImage(
            model = coverImage,
            placeholder = painterResource(id = R.drawable.profile_icon),
            contentDescription = "cover image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(bottom = 63.dp)
            .height(121.dp)
            .fillMaxWidth()
            .align(alignment = Alignment.TopCenter))

        AsyncImage(
            model = profileImage,
            placeholder = painterResource(id = R.drawable.profile_icon),
            contentDescription = "Profile Image",
        modifier = Modifier
            .padding(start = 10.dp)
            .size(126.dp)
            .border(width = 2.dp, shape = CircleShape, color = Color.White)
            .clip(shape = CircleShape)
            .align(alignment = Alignment.BottomStart),
            contentScale = ContentScale.Crop
            )
    }
}

@Preview
@Composable
fun ProfilePagePreview(){
    ProfilePage(user = currentUser)
}