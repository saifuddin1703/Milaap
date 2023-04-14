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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
fun SignupPage(parentNavController: NavHostController) {
    val viewModel: AuthViewModel = hiltViewModel()

    var isWrongEmail by remember{
        mutableStateOf(false)
    }

    var isWrongEnrollment by remember{
        mutableStateOf(false)
    }

    var name by remember{
        mutableStateOf("")
    }

    var email by remember{
        mutableStateOf("")
    }

    var enrollmentId by remember{
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
                value = name,
                onValueChange = {
                    name = it
                },
                label = { Text("Name") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = "name icon") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(50),
                maxLines = 1
            )

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    isWrongEmail = false
                },
                label = { if (isWrongEmail) Text("Invalid email") else Text("Email") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = "email icon") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(50),
                isError = isWrongEmail,
                maxLines = 1
            )

            OutlinedTextField(
                value = enrollmentId,
                onValueChange = {
                    enrollmentId = it
                    isWrongEnrollment = false
                },
                label = { if (isWrongEnrollment) Text("Invalid roll number") else Text("Enrollment number") },
                leadingIcon = { Icon(Icons.Default.AccountCircle, contentDescription = "roll icon") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(50),
                isError = isWrongEnrollment,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                enabled = !isloading,
                onClick = {
//                    var enrollmentId: String? = null
//                    var email: String? = null
                    if (!enrollmentId.startsWith("0832")) {
                        // do something
                        isWrongEnrollment = true
                    }else
                    if (!Check.isEmail(email)) {
                        // do something
                        isWrongEmail = true
                    }else
                        if (name.isBlank()){
                            Toast.makeText(context,"Name cannot be Blank",Toast.LENGTH_SHORT).show()
                        }
                    else {
                        coroutineScope.launch {
//                        Log.d("TAG", "button clicked")

                            isloading = true
                            viewModel.signup(email = email,name = name, enrollmentId = enrollmentId,
                                success = {
                                    parentNavController.navigate("setPassword/$email/$it")
                                    isloading = false
                                },
                                error = {
                                    isloading = false
                                    Toast.makeText(context,"Some error occurred, Please try again",Toast.LENGTH_SHORT).show()


                                })
//                        Log.d("TAG", result.toString())
                        }
                    }
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(50),
                content = { Text("Signup", fontSize = 20.sp) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppThemeColor,
                    contentColor = Color.White
                )
            )

            Row(modifier = Modifier
                .padding(top = 10.dp)
                .align(alignment = Alignment.CenterHorizontally)) {

                Text(text = "Already signedup? ")
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Login", textDecoration = TextDecoration.Underline, color = Color.Blue,
                    modifier = Modifier.clickable {
                        parentNavController.navigate("login"){
                            popUpTo("signup"){
                                inclusive = true
                            }
                        }
                    })
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
fun SignupPagePreview(){
    SignupPage(parentNavController = rememberNavController())
}