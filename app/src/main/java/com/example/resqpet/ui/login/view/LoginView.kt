package com.example.resqpet.ui.login.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.resqpet.R
import com.example.resqpet.navigation.NavigationState
import com.example.resqpet.ui.login.viewmodel.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginResQPet(navController: NavController) {

    val loginViewModel: LoginViewModel = viewModel()

    val email by loginViewModel.email.collectAsState()
    val password by loginViewModel.password.collectAsState()
    val passwordVisible by loginViewModel.isPasswordVisible.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.backgroundColor)),

        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {

            IconButton(onClick = { navController.navigate(NavigationState.Home.route) }, modifier = Modifier.size(65.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.backbutton1),
                    contentDescription = "Descripción de la imagen",
                )
            }

            Image(
                painter = painterResource(id = R.drawable.bgdeco1),
                contentDescription = "decoration",
                modifier = Modifier
                    .size(500.dp)
                    .padding(top = 0.dp, start = 0.dp)
                    .align(Alignment.TopEnd).offset((150).dp, (-120).dp)
            )

            Spacer(modifier = Modifier.height(50.dp))

            Image(
                painter = painterResource(id = R.drawable.catto1),
                contentDescription = "cat1",
                modifier = Modifier
                    .size(270.dp)
                    .padding(top = 0.dp, start = 0.dp)
                    .align(Alignment.CenterEnd).offset((-70).dp, (97).dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd).offset((0).dp, (-10).dp)
                .padding(30.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.99f)
                    .height(360.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(colorResource(R.color.primaryColor))
                    .padding(30.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.hello),
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.backgroundColor),
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(1.dp))

                    Text(
                        text = stringResource(R.string.sign_in_to_your_account),
                        color = colorResource(R.color.backgroundColor),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { newEmail -> loginViewModel.setEmail(newEmail) },
                        label = { Text(stringResource(R.string.email)) },
                        leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email Icon", tint = colorResource(R.color.iconColor)) },
                        placeholder = { Text(stringResource(R.string.enter_your_email)) },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = colorResource(R.color.backgroundColor),
                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                            focusedLabelColor = colorResource(R.color.backgroundColor),
                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                        )
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { newPassword -> loginViewModel.setPassword(newPassword) },
                        label = { Text(stringResource(R.string.password) )},
                        trailingIcon = {
                            val image = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                            IconButton(onClick = { loginViewModel.togglePasswordVisibility() }) { // Notifica al ViewModel el cambio
                                Icon(image, contentDescription = "Toggle password visibility", tint = colorResource(R.color.iconColor)) // Asume que 'colorResource(R.color.iconColor)' está definido en algún lugar
                            }
                        },
                        placeholder = { Text(stringResource(R.string.enter_your_password)) },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = colorResource(R.color.backgroundColor),
                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                            focusedLabelColor = colorResource(R.color.backgroundColor),
                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                        ),
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            loginViewModel.onLoginClicked()
                            navController.navigate(NavigationState.MainMenu.route)
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(R.color.secondaryColor)),
                    ) {
                        Text(
                            text = stringResource(R.string.login),
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.backgroundColor),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                }
            }
        }
    }
}


