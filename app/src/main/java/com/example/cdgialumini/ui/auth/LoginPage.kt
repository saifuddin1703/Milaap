package com.example.cdgialumini.ui.auth

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cdgialumini.data.currentUser
import com.example.cdgialumini.data.users
import com.example.cdgialumini.ui.theme.AppThemeColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavHostController) {
    var isWrongPassword by remember{
        mutableStateOf(false)
    }

    var isWrongUsername by remember{
        mutableStateOf(false)
    }

    var username by remember{
        mutableStateOf("")
    }

    var password by remember{
        mutableStateOf("")
    }

    val coroutineScope = rememberCoroutineScope()
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        Column(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(color = Color.White)
            .align(alignment = Alignment.Center)) {
            OutlinedTextField(
                value = username,
                onValueChange = {
                                username = it
                },
                label = { if (isWrongUsername) Text("Invalid roll number/code") else Text("Roll Number/Code") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = "email icon") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(50),
                isError = isWrongUsername
            )

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = { if (isWrongPassword) Text("Invalid password") else Text("Password") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "password icon") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(50),
                visualTransformation = PasswordVisualTransformation(),
                isError = isWrongPassword
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                onClick = {
                        if(username.startsWith("0832") || username.startsWith("TM")) {
                            val user = users.find {
                                it.rollNumber == username
                            }
                            if (user != null){
                                if (password != user.password){
                                    isWrongPassword = true
                                }else{
                                    // navigate to home page
                                    // delay of 1.5 sec to be removed later
//                            coroutineScope.launch {
//                                delay(1500)
                                    Log.d("TAG","clicked")
                                    isWrongPassword = false
                                    isWrongUsername = false
                                    currentUser = user
                                    navController.navigate("app")
//                            }
                                }
                            }else{
                                isWrongUsername = true
                            }

                        }else
                            isWrongUsername = true

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(50),
                content = { Text("Login", fontSize = 20.sp) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppThemeColor,
                    contentColor = Color.White
                )
            )
        }
    }


}

@Preview
@Composable
fun LoginPagePreview(){
    LoginPage(rememberNavController())
}
