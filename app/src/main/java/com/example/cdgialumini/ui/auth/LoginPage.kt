package com.example.cdgialumini.ui.auth

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cdgialumini.ui.auth.viewmodel.AuthViewModel
import com.example.cdgialumini.ui.theme.AppThemeColor
import com.example.cdgialumini.utils.Check
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController : NavHostController) {
    val viewModel:AuthViewModel = hiltViewModel()

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

    var isloading by remember{
        mutableStateOf(false)
    }

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    )
    {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .background(color = Color.White)
                .align(alignment = Alignment.Center)
        ) {
            OutlinedTextField(
                value = username,
                onValueChange = {
                    username = it
                },
                label = { if (isWrongUsername) Text("Invalid roll number/code") else Text("Roll Number/Code/Email") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = "email icon") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(50),
                isError = isWrongUsername,
                maxLines = 1
            )

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = { if (isWrongPassword) Text("Invalid password") else Text("Password") },
                leadingIcon = {
                    Icon(
                        Icons.Default.Lock,
                        contentDescription = "password icon"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(50),
                visualTransformation = PasswordVisualTransformation(),
                isError = isWrongPassword,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                enabled = !isloading,
                onClick = {
                    var enrollmentId: String? = null
                    var email: String? = null
                    if (username.startsWith("0832") || username.startsWith("TM")) {
                        // do something
                        enrollmentId = username
                    } else if (Check.isEmail(username)) {
                        // do something
                        email = username
                    } else
                        isWrongUsername = true

                    coroutineScope.launch {
//                        Log.d("TAG", "button clicked")

                        isloading = true
                        viewModel.login(email, password, enrollmentId,
                            success = {
                              navController.navigate("app"){
                                  popUpTo("login"){inclusive = true}
                              }
                                isloading = false
                            },
                            error = {
                                isloading = false

                                when(it){
                                    "Invalid password" -> {
                                        isWrongPassword = true
                                    }
                                    "Invalid username" -> {
                                        isWrongUsername = true
                                    }
                                    else->{
                                        Toast.makeText(context,"Some error occurred, please try again",Toast.LENGTH_SHORT).show()
                                    }
                                }
                            })
//                        Log.d("TAG", result.toString())
                    }
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

            Row(modifier = Modifier
                .padding(top = 10.dp)
                .align(alignment = CenterHorizontally)) {

                Text(text = "Not signedup? ")
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Signup", textDecoration = TextDecoration.Underline, color = Color.Blue)
            }
        }


        if (isloading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Transparent)
            ) {

                CircularProgressIndicator(
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }
        }
    }


}

@Preview
@Composable
fun LoginPagePreview(){
    LoginPage(rememberNavController())
}
