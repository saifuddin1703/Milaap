package com.example.cdgialumini.ui.auth

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cdgialumini.ui.auth.viewmodel.AuthViewModel
import com.example.cdgialumini.ui.theme.AppThemeColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetPasswordPage(
    email: String,
    sessionId: String,
    parentNavController: NavHostController
){

    val viewModel: AuthViewModel = hiltViewModel()

    var isWrongPassword by remember{
        mutableStateOf(false)
    }

    var isWrongOtp by remember{
        mutableStateOf(false)
    }

    var password by remember{
        mutableStateOf("")
    }

    var otp by remember{
        mutableStateOf("")
    }

    var confirmPassword by remember{
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
                value = password,
                enabled = !isloading,
                onValueChange = {
                    password = it
                    isWrongPassword = false
                },
                label = {Text("Password") },
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
                maxLines = 1
            )

            OutlinedTextField(
                value = confirmPassword,
                enabled = !isloading,
                onValueChange = {
                    confirmPassword = it
                    isWrongPassword = false
                },
                label = {if (isWrongPassword) Text("Password not matching") else Text("Confirm Password") },
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

            OutlinedTextField(
                value = otp,
                onValueChange = {
                    otp = it
                    isWrongOtp = false
                },
                label = { if (isWrongOtp) Text("Invalid OTP") else Text("OTP") },
                leadingIcon = { Icon(Icons.Default.Phone, contentDescription = "email icon") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(50),
                isError = isWrongOtp,
                maxLines = 1
            )

            Row(modifier = Modifier
                .padding(top = 10.dp)
                .align(alignment = End)) {

                var isOTPSending by remember{
                    mutableStateOf(false)
                }

                if (isOTPSending){
                    CircularProgressIndicator(
                        modifier = Modifier.size(5.dp)
                    )
                }

                Text(
                    text = "Resend OTP",
                    textDecoration = TextDecoration.Underline,
                    color = Color.Blue,
                    modifier = Modifier.clickable {
                        coroutineScope.launch {
                            isOTPSending = true
                            viewModel.resendOTP(email = email, sessionId = sessionId, success = {
                                                                                                isOTPSending = false
                            }, error = {
                                isOTPSending = false
                                isWrongOtp = true
                                Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
                            })
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                enabled = !isloading,
                onClick = {
                    if (password.isBlank()) {
                        // do something
                        Toast.makeText(context,"Password cannot be blank",Toast.LENGTH_SHORT).show()
                    }else if (otp.isBlank()){
                        isWrongOtp = true;
                    } else if (password != confirmPassword){
                        isWrongPassword = true
                    }
                    else
                    {
                        coroutineScope.launch {
//                        Log.d("TAG", "button clicked")

                            isloading = true
                            viewModel.setPassword(email = email, sessionId = sessionId, password = password,otp = otp,
                                success = {
                                    parentNavController.navigate("app") {
                                        popUpTo("setPassword") { inclusive = true }
                                    }
                                    isloading = false
                                    parentNavController.navigate("app"){
                                        popUpTo("setPassword")
                                    }
                                },
                                error = {
                                    isloading = false

                                    Toast.makeText(context,"Some Error occurred, Please try again ",Toast.LENGTH_SHORT).show()

                                })
//                        Log.d("TAG", result.toString())
                        }
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
                .align(alignment = Alignment.CenterHorizontally)) {

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