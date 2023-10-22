package com.example.resqpet.ui.editprofile.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.resqpet.R
import com.example.resqpet.ui.editprofile.viewmodel.EditProfileViewModel
import com.example.resqpet.ui.mainmenu.view.primaryColor

val colorIcon = Color(0xFFE9B384)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen() {

    val viewModel: EditProfileViewModel = viewModel()
    val profileData by viewModel.profileData
    val passwordVisible by viewModel.isPasswordVisible.collectAsState()


    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F2DE))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState, enabled = true),
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
                        value = profileData.name,
                        onValueChange = { newValue -> viewModel.onNameChanged(newValue)},
                        label = { Text("Full Name") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF4F2DE),
                            focusedIndicatorColor = Color(0xFFA1CCD1),
                            focusedLabelColor = Color(0xFFFFFFFF),
                            textColor = primaryColor
                        ),
                        trailingIcon =  { Icon(Icons.Filled.Person, contentDescription = null, tint = colorIcon) }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = { newValue -> viewModel.onEmailChanged(newValue) },
                        label = { Text("Contact Email") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF4F2DE),
                            focusedIndicatorColor = Color(0xFFA1CCD1),
                            focusedLabelColor = Color(0xFFFFFFFF)
                        ),
                        trailingIcon =  { Icon(Icons.Filled.Email, contentDescription = null, tint = colorIcon) }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = { newValue -> viewModel.onPwdChanged(newValue) },
                        label = { Text("Password") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF4F2DE),
                            focusedIndicatorColor = Color(0xFFA1CCD1),
                            focusedLabelColor = Color(0xFFFFFFFF)
                        ),
                        trailingIcon = {
                            val image = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                            IconButton(onClick = { viewModel.togglePasswordVisibility() }) { // Notifica al ViewModel el cambio
                                Icon(image, contentDescription = "Toggle password visibility", tint = colorIcon) // Asume que 'colorIcon' está definido en algún lugar
                            }
                        },
                        placeholder = { Text("Enter your password") },
                        singleLine = true,
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                    )



                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = { newValue -> viewModel.onPhoneChanged(newValue) },
                        label = { Text("Phone Number") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF4F2DE),
                            focusedIndicatorColor = Color(0xFFA1CCD1),
                            focusedLabelColor = Color(0xFFFFFFFF)
                        ),
                        trailingIcon =  { Icon(Icons.Filled.Phone, contentDescription = null, tint = colorIcon) }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = { newValue -> viewModel.onAddressChanged(newValue) },
                        label = { Text("Address") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF4F2DE),
                            focusedIndicatorColor = Color(0xFFA1CCD1),
                            focusedLabelColor = Color(0xFFFFFFFF)
                        ),
                        trailingIcon =  { Icon(Icons.Filled.Home, contentDescription = null, tint = colorIcon) }
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            modifier = Modifier
                                .padding(15.dp),
                            onClick = { viewModel.discardChanges() },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFA1CCD1)
                            )
                        ) {
                            Text(text = "Cancel", color = Color(0xFFF4F2DE), fontSize = 20.sp)
                        }

                        Button(
                            modifier = Modifier
                                .padding(15.dp),
                            onClick = { viewModel.saveProfile() },
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