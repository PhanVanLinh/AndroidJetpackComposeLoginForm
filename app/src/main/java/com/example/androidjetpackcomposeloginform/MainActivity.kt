package com.example.androidjetpackcomposeloginform

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidjetpackcomposeloginform.ui.theme.AndroidJetpackComposeLoginFormTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetpackComposeLoginFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginForm()
                }
            }
        }
    }
}

@Composable
fun LoginForm() {
    Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            val modifier = Modifier.padding(vertical = 4.dp)

            Text(
                "Login Form",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = modifier.then(
                    Modifier.background(
                        Color(android.graphics.Color.RED),
                        RectangleShape
                    )
                )
            )

            val usernameState = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = usernameState.value,
                onValueChange = {
                    usernameState.value = it
                },
                placeholder = { Text("Username") },
                modifier = modifier
            )

            Text(text = "Password")
            val passwordState = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = passwordState.value,
                onValueChange = {
                    passwordState.value = it
                },
                visualTransformation = PasswordVisualTransformation(),
                placeholder = { Text("Password") },
                modifier = modifier
            )

            val textSubmitState =
                remember { mutableStateOf("Your data that you submmit will display here") }
            Button(onClick = {
                val username = usernameState.value.text
                val password = passwordState.value.text

                textSubmitState.value = "your username: $username your password:$password"
            }) {
                Text("Login")
            }

            Text(
                text = textSubmitState.value
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidJetpackComposeLoginFormTheme {
        LoginForm()
    }
}