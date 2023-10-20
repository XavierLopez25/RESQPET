package com.example.resqpet.screens

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.resqpet.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginResQPet() {

    val colorBackground = Color(0xFFF4F2DE)
    val colorChartText = Color(0xFF2A5D71)
    val colorButton = Color(0xFFA1CCD1)
    val colorIcon = Color(0xFFE9B384)

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorBackground),

        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {

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
                    .background(colorChartText)
                    .padding(30.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Hello!",
                        fontWeight = FontWeight.Bold,
                        color = colorBackground,
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(1.dp))

                    Text(
                        text = "Sign in to your account",
                        color = colorBackground,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email Icon", tint = colorIcon) },
                        placeholder = { Text("Enter your email") },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = colorBackground,
                            focusedIndicatorColor = colorBackground,
                            focusedLabelColor = colorBackground,
                            unfocusedLabelColor = colorBackground,
                        )
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        trailingIcon = {
                            val image = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(image, contentDescription = "Toggle password visibility", tint = colorIcon)
                            }
                        },
                        placeholder = { Text("Enter your password") },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = colorBackground,
                            focusedIndicatorColor = colorBackground,
                            focusedLabelColor = colorBackground,
                            unfocusedLabelColor = colorBackground,
                        ),
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            /* no hace nada */
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(colorButton),
                    ) {
                        Text(
                            text = "Login",
                            fontWeight = FontWeight.Bold,
                            color = colorBackground,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                }
            }
        }
    }
}