package com.example.resqpet.ui.register.view

import android.util.Patterns
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.resqpet.R
import com.example.resqpet.navigation.NavigationState
import com.example.resqpet.ui.additionalfeatures.PlaceholderTransformation
import com.example.resqpet.ui.register.viewmodel.RegisterViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterResQPet(navController: NavController, registerViewModel: RegisterViewModel) {

    val viewModel: RegisterViewModel = registerViewModel


    // Observar los StateFlows como estados en Compose
    val username by viewModel.username.collectAsState()
    val cname by viewModel.Cname.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val passwordConfirm by viewModel.passwordC.collectAsState()
    val passwordVisible by viewModel.passwordVisible.collectAsState()
    val isEmailValid by viewModel.isEmailValid.collectAsState()
    val passwordsMatch by viewModel.passwordsMatch.collectAsState()
    val isFormValid by viewModel.isFormValid.collectAsState()
    val isPasswordLengthValid by viewModel.isPasswordLengthValid.collectAsState()



    val textFieldColors = if (isEmailValid && passwordsMatch && isPasswordLengthValid) {
            TextFieldDefaults.textFieldColors(
                containerColor = colorResource(R.color.backgroundColor),
                focusedIndicatorColor = colorResource(R.color.backgroundColor),
                focusedLabelColor = colorResource(R.color.backgroundColor),
                unfocusedLabelColor = colorResource(R.color.backgroundColor),
                textColor = colorResource(R.color.primaryColor),
                cursorColor = colorResource(R.color.primaryColor)
            )
        } else {
            TextFieldDefaults.textFieldColors(
                containerColor = colorResource(R.color.backgroundColor),
                focusedIndicatorColor = colorResource(id = R.color.errorColor),
                unfocusedIndicatorColor = colorResource(id = R.color.errorColor),
                cursorColor = colorResource(id = R.color.errorColor),
                focusedSupportingTextColor = colorResource(id = R.color.errorColor),
                unfocusedSupportingTextColor = colorResource(id = R.color.errorColor),
                errorSupportingTextColor = colorResource(id = R.color.errorColor),
                errorIndicatorColor = colorResource(id = R.color.errorColor),
                textColor = colorResource(R.color.primaryColor)

            )
        }




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
                    .align(Alignment.TopEnd)
                    .offset((150).dp, (-130).dp)
            )

            Spacer(modifier = Modifier.height(50.dp))

            Image(
                painter = painterResource(id = R.drawable.doggo1),
                contentDescription = "doggo1",
                modifier = Modifier
                    .size(230.dp)
                    .padding(top = 0.dp, start = 0.dp)
                    .align(Alignment.CenterEnd)
                    .offset((-70).dp, (10).dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .offset((0).dp, (-2).dp)
                .padding(30.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.99f)
                    .height(420.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(colorResource(R.color.primaryColor))
                    .padding(30.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.welcome),
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.backgroundColor),
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.padding(top = 2.dp)
                    )

                    Spacer(modifier = Modifier.height(1.dp))

                    Text(
                        text = stringResource(R.string.create_a_new_account),
                        color = colorResource(R.color.backgroundColor),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(top = 2.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = cname,
                        onValueChange = {  newValue -> viewModel.setCompleteName(newValue)},
                        label = { Text(stringResource(R.string.enter_your_public_username)) },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = "User Icon",
                                tint = colorResource(R.color.iconColor)
                            )
                        },
                        placeholder = { Text(stringResource(R.string.enter_your_username)) },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = colorResource(R.color.backgroundColor),
                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                            focusedLabelColor = colorResource(R.color.backgroundColor),
                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                            cursorColor = colorResource(R.color.primaryColor),
                            textColor = colorResource(R.color.primaryColor)
                        ),
                        visualTransformation = if (cname.isEmpty()) {
                            PlaceholderTransformation("Enter the your public username")
                        } else VisualTransformation.None
                    )

                    Spacer(modifier = Modifier.height(10.dp))


                    OutlinedTextField(
                        value = username,
                        onValueChange = {  newValue -> viewModel.setUsername(newValue)},
                        label = { Text("Enter your complete name") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = "User Icon",
                                tint = colorResource(R.color.iconColor)
                            )
                        },
                        placeholder = { Text("Enter your complete name") },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = colorResource(R.color.backgroundColor),
                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                            focusedLabelColor = colorResource(R.color.backgroundColor),
                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                            cursorColor = colorResource(R.color.primaryColor),
                            textColor = colorResource(R.color.primaryColor)
                        ),
                        visualTransformation = if (username.isEmpty()) {
                            PlaceholderTransformation("Enter the your username")
                        } else VisualTransformation.None
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = {  newValue -> viewModel.setEmail(newValue)
                            isEmailValid(email) },
                        label = { Text(stringResource(R.string.email)) },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Email,
                                contentDescription = "Email Icon",
                                tint = colorResource(R.color.iconColor)
                            )
                        },
                        placeholder = { Text(stringResource(R.string.enter_your_email)) },
                        singleLine = true,
                        colors = textFieldColors,
                        visualTransformation = if (email.isEmpty()) {
                            PlaceholderTransformation("Enter the your email")
                        } else VisualTransformation.None)

                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = {  newValue -> viewModel.setPassword(newValue)},
                        label = { Text(stringResource(R.string.enter_your_password)) },
                        trailingIcon = {
                            val image =
                                if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                            IconButton(onClick = { viewModel.togglePasswordVisibility() }) {
                                Icon(
                                    image,
                                    contentDescription = "Toggle password visibility",
                                    tint = colorResource(R.color.iconColor)
                                )
                            }
                        },
                        placeholder = { Text(stringResource(R.string.enter_your_password)) },
                        singleLine = true,
                        colors = textFieldColors,
                        visualTransformation = if (password.isEmpty()) {
                            PlaceholderTransformation("Enter the your password")
                        } else if(passwordVisible){ VisualTransformation.None }else PasswordVisualTransformation()                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = passwordConfirm,
                        onValueChange = {  newValue -> viewModel.setPasswordC(newValue)},
                        label = { Text(stringResource(R.string.confirm_your_password)) },
                        trailingIcon = {
                            val image =
                                if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                            IconButton(onClick = { viewModel.togglePasswordVisibility() }) {
                                Icon(
                                    image,
                                    contentDescription = "Toggle password visibility",
                                    tint = colorResource(R.color.iconColor)
                                )
                            }
                        },
                        placeholder = { Text(stringResource(R.string.confirm_your_password)) },
                        singleLine = true,
                        colors = textFieldColors,
                        visualTransformation = if (passwordConfirm.isEmpty()) {
                            PlaceholderTransformation("Verify your password")
                        } else if(passwordVisible){ VisualTransformation.None }else PasswordVisualTransformation())

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            if(isFormValid){
                                viewModel.onRegisterClicked(username, cname, email, password)
                                navController.navigate(NavigationState.MainMenu.route)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(R.color.secondaryColor)),
                        enabled = isFormValid // Enable or disable the button based on form validation
                    ) {
                        Text(
                            text = stringResource(R.string.register),
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

fun isEmailValid(email: String): Boolean {
    return if (email.isEmpty()) true else Patterns.EMAIL_ADDRESS.matcher(email).matches()
}