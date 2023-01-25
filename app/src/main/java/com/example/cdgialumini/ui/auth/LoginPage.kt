package com.example.cdgialumini.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cdgialumini.ui.theme.AppThemeColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        Column(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(color = Color.White)
            .align(alignment = Alignment.Center)) {
            OutlinedTextField(
                value = "",
                onValueChange = {

                },
                label = { Text("Roll Number/Code") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = "email icon") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(50)
            )

            OutlinedTextField(
                value = "",
                onValueChange = {

                },
                label = { Text("Password") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "password icon") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(50),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                onClick = { /* handle login */ },
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
    LoginPage()
}
