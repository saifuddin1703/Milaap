package com.example.cdgialumini.ui

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cdgialumini.R
import com.example.cdgialumini.ui.auth.viewmodel.AuthViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(parentNavController: NavHostController) {

    val viewModel : AuthViewModel = hiltViewModel()


    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)){

        Image(
            painter = painterResource(id = R.drawable.cdgi_logo),
            contentDescription = null,
            modifier = Modifier.align(alignment = Alignment.Center)
        )
    }
    LaunchedEffect(key1 = true){

        delay(2000)

        try {
            val isLoggedIn = viewModel.isLoggedIn()
            if (isLoggedIn){
                parentNavController.navigate("app"){
                    popUpTo("splashScreen"){inclusive = true}
                }
            }else{
                parentNavController.navigate("login"){
                    popUpTo("splashScreen"){inclusive = true}
                }
            }
        }catch (e : Exception){
            parentNavController.navigate("login"){
                popUpTo("splashScreen"){inclusive = true}
            }
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview(){
    SplashScreen(parentNavController = rememberNavController())
}