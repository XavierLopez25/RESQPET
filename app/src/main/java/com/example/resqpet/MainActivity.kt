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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.resqpet.navigation.Navigation
import com.example.resqpet.ui.createpost.viewmodel.CreatePostViewModel
import com.example.resqpet.ui.donation.view.Donation
import com.example.resqpet.ui.login.view.LoginResQPet
import com.example.resqpet.ui.start.view.MainMenu
import com.example.resqpet.ui.editprofile.view.EditProfileScreen
import com.example.resqpet.ui.mainmenu.view.MainMenuResQPet
import com.example.resqpet.ui.petlist.view.PetList
import com.example.resqpet.ui.register.view.RegisterResQPet
import com.example.resqpet.ui.theme.RESQPETTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RESQPETTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val sharedViewModel: CreatePostViewModel by viewModels()


                    Navigation(sharedViewModel)


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