package com.example.resqpet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.resqpet.navigation.Navigation
import com.example.resqpet.ui.createpost.viewmodel.CreatePostViewModel
import com.example.resqpet.ui.login.viewmodel.LoginViewModel
import com.example.resqpet.ui.register.viewmodel.RegisterViewModel
import com.example.resqpet.ui.theme.RESQPETTheme
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Firebase.initialize(this)
        setContent {
            RESQPETTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val sharedViewModel: CreatePostViewModel by viewModels()
                    val signUpModel: RegisterViewModel by viewModels()
                    val loginModel: LoginViewModel by viewModels()

                    Navigation(sharedViewModel, signUpModel, loginModel)

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RESQPETTheme {
        Greeting("Android")
    }
}