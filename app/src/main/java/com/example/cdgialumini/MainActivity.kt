package com.example.cdgialumini

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cdgialumini.ui.auth.LoginPage
import com.example.cdgialumini.ui.components.TopAppBar
import com.example.cdgialumini.ui.directory.DirectoryPage
import com.example.cdgialumini.ui.home.HomePage
import com.example.cdgialumini.ui.messenging.MessagesPage
import com.example.cdgialumini.ui.post.PostDetailPage
import com.example.cdgialumini.ui.theme.AppThemeColor
import com.example.cdgialumini.ui.theme.CDGIAluminiTheme
import com.example.cdgialumini.ui.utils.BottomNavigationItems

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CDGIAluminiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val parentNavController = rememberNavController()
                    // parent nav host
                    val isLoggedIn by remember{
                        mutableStateOf(false)
                    }

                    val startDestination = if (isLoggedIn) "app" else "login"

                    NavHost(navController = parentNavController, startDestination = startDestination){
                        composable("app"){
                            CDGIAluminiApp()
                        }

                        composable("login"){
                            LoginPage()
                        }

                        composable("postDetailPage"){
                            PostDetailPage()
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CDGIAluminiApp(){
    var topBarTitle by remember{
        mutableStateOf("Home")
    }

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(title = topBarTitle)
        },
        bottomBar = {

            var selectedIndex by remember {
                mutableStateOf(0)
            }
            val items = listOf(
                BottomNavigationItems.Home,
                BottomNavigationItems.Directory,
                BottomNavigationItems.Events,
                BottomNavigationItems.Messages,
                BottomNavigationItems.Profile
            )
            NavigationBar (
                containerColor = Color.White,
            ){
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                            topBarTitle = item.title

                            when(selectedIndex){
                                0 ->{
                                    navController.navigate("home")
                                }
                                2 ->{
                                    navController.navigate("directory")
                                }
                                3 ->{}
                                4 ->{}
                                5 ->{}
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White
                        ),
                        icon = {
                               Image(painter = painterResource(item.iconLocation),
                                   contentDescription = "Item Icon",
                               modifier = Modifier.size(30.dp))
                        },
                        label = {
                            Text(text = item.title)
                        }
                    )
                }
            }
        }
    ) {


        NavHost(navController = navController, startDestination = "home"){

            composable("home"){
               HomePage()
           }

            composable("directory"){
                DirectoryPage()
            }

            composable("messages"){
                MessagesPage()
            }
        }
    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CDGIAluminiTheme {
        CDGIAluminiApp()
    }
}