package com.example.resqpet.screens

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.resqpet.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen() {

    val scrollState = rememberScrollState()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F2DE))
    ) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(scrollState, enabled = true),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color(0xFFA1CCD1)),
                contentAlignment = Alignment.TopStart,
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.paw2),
                        contentDescription = null
                    )
                    Text(
                        text = "Edit Profile",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 20.sp,
                        color = Color(0xFFF4F2DE)
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            ProfilePhotoWithEditButton()

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(Color(0xFF2A5D71))
                    .padding(23.dp),
            ) {
                Column {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Full Name") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF4F2DE),
                            focusedIndicatorColor = Color(0xFFA1CCD1),
                            focusedLabelColor = Color(0xFFFFFFFF)
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Contact Email") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF4F2DE),
                            focusedIndicatorColor = Color(0xFFA1CCD1),
                            focusedLabelColor = Color(0xFFFFFFFF)
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF4F2DE),
                            focusedIndicatorColor = Color(0xFFA1CCD1),
                            focusedLabelColor = Color(0xFFFFFFFF)
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Phone Number") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF4F2DE),
                            focusedIndicatorColor = Color(0xFFA1CCD1),
                            focusedLabelColor = Color(0xFFFFFFFF)
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Address") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF4F2DE),
                            focusedIndicatorColor = Color(0xFFA1CCD1),
                            focusedLabelColor = Color(0xFFFFFFFF)
                        )
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            modifier = Modifier
                                .padding(15.dp),
                            onClick = { /* Handle Cancel Action */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFA1CCD1)
                            )
                        ) {
                            Text(text = "Cancel", color = Color(0xFFF4F2DE), fontSize = 20.sp)
                        }

                        Button(
                            modifier = Modifier
                                .padding(15.dp),
                            onClick = { /* Handle Save Action */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFA1CCD1)
                            )
                        ) {
                            Text(text = "Save", color = Color(0xFFF4F2DE), fontSize = 20.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfilePhotoWithEditButton() {
    Box(
        modifier = Modifier.size(230.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.catto2),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .size(70.dp)
        )

        // Edit button
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.Gray)
                .clickable { /* handle click event, e.g., open photo picker */ },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit Profile Photo",
                tint = Color.White
            )
        }
    }
}
@Preview
@Composable
fun PreviewEditProfileScreen() {
    EditProfileScreen()
}