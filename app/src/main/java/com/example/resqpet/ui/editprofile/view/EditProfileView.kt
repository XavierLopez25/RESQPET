package com.example.resqpet.ui.editprofile.view

import android.content.ContentValues
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.resqpet.R
import com.example.resqpet.navigation.NavigationState
import com.example.resqpet.ui.editprofile.viewmodel.EditProfileViewModel
import java.net.URI


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(navController: NavController) {

    val viewModel: EditProfileViewModel = viewModel()
    val profileData by viewModel.profileData
    val passwordVisible by viewModel.isPasswordVisible.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchUserProfile()
    }


    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.backgroundColor))
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
                    .background(colorResource(R.color.secondaryColor)),
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
                        text = stringResource(R.string.edit_profile),
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 20.sp,
                        color = colorResource(R.color.backgroundColor)
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            ProfilePhotoWithEditButton(viewModel)

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(Color(0xFF2A5D71))
                    .padding(23.dp),
            ) {
                Column {
                    OutlinedTextField(
                        value = profileData.completeName,
                        onValueChange = { newValue -> viewModel.onCompleteNameChanged(newValue)},
                        label = { Text(stringResource(R.string.full_name)) },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = colorResource(R.color.backgroundColor),
                            focusedIndicatorColor = colorResource(R.color.secondaryColor),
                            focusedLabelColor = colorResource(R.color.textColor),
                            textColor = colorResource(R.color.primaryColor)
                        ),
                        trailingIcon =  { Icon(Icons.Filled.Person, contentDescription = null, tint = colorResource(R.color.iconColor)) }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = profileData.username,
                        onValueChange = { newValue -> viewModel.onNameChanged(newValue) },
                        label = { Text(stringResource(R.string.username1)) },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = colorResource(R.color.backgroundColor),
                            focusedIndicatorColor = colorResource(R.color.secondaryColor),
                            focusedLabelColor = colorResource(R.color.textColor),
                            textColor = colorResource(R.color.primaryColor)

                        ),
                        trailingIcon =  { Icon(Icons.Filled.Email, contentDescription = null, tint = colorResource(R.color.iconColor)) }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = profileData.password,
                        onValueChange = { newValue -> viewModel.onPwdChanged(newValue) },
                        label = { Text(stringResource(R.string.password1)) },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = colorResource(R.color.backgroundColor),
                            focusedIndicatorColor = colorResource(R.color.secondaryColor),
                            focusedLabelColor = colorResource(R.color.textColor),
                            textColor = colorResource(R.color.primaryColor)

                        ),
                        trailingIcon = {
                            val image = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                            IconButton(onClick = { viewModel.togglePasswordVisibility() }) { // Notifica al ViewModel el cambio
                                Icon(image, contentDescription = "Toggle password visibility", tint = colorResource(R.color.iconColor)) // Asume que 'colorResource(R.color.iconColor)' está definido en algún lugar
                            }
                        },
                        placeholder = { Text(stringResource(R.string.enter_your_password1)) },
                        singleLine = true,
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            modifier = Modifier
                                .padding(15.dp),
                            onClick = { navController.navigate(NavigationState.MainMenu.route){
                                popUpTo(NavigationState.MainMenu.route) { inclusive = true }} },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.secondaryColor)
                            )
                        ) {
                            Text(text = stringResource(R.string.cancel1), color = colorResource(R.color.backgroundColor), fontSize = 20.sp)
                        }

                        Button(
                            modifier = Modifier
                                .padding(15.dp),
                            onClick = { viewModel.saveProfile()
                                navController.navigate(NavigationState.MainMenu.route){
                                    popUpTo(NavigationState.MainMenu.route) { inclusive = true }}},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.secondaryColor)
                            )
                        ) {
                            Text(text = stringResource(R.string.save1), color = colorResource(R.color.backgroundColor), fontSize = 20.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfilePhotoWithEditButton(viewModel: EditProfileViewModel) {

    val context = LocalContext.current

    val selectedImageUri = viewModel.selectedImageUri.observeAsState().value

    val imagePainter = if (!selectedImageUri.isNullOrEmpty()) {
        // Load image from the Uri if it's not null or empty
        rememberImagePainter(data = selectedImageUri)
    } else {
        // Load a default image from resources if the URI is null or empty
        painterResource(id = R.drawable.noimageuploaded)
    }


    val pickImageLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            // Save the Uri in your ViewModel
            viewModel.saveImageUri(uri)
        }


    val takePictureLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicturePreview()) { bitmap: Bitmap? ->
            if (bitmap != null) {
                println("Success: Bitmap received.")

                // Convert Bitmap to Uri and save it in your ViewModel
                val uri = bitmap.let { imageBitmap ->
                    val values = ContentValues().apply {
                        // Ensure unique file name
                        put(
                            MediaStore.Images.Media.DISPLAY_NAME,
                            "Title_${System.currentTimeMillis()}.jpg"
                        )
                        put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                    }

                    val contentResolver = context.contentResolver
                    val imageUri =
                        contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

                    imageUri?.let {
                        contentResolver.openOutputStream(it)?.use { outputStream ->
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
                        }
                    }
                    imageUri
                }
                viewModel.saveImageUri(uri)
            } else {
                println("Error: Bitmap is null.")
            }
        }

    Box(
        modifier = Modifier.size(230.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .size(70.dp)
        )

            IconButton(onClick = { takePictureLauncher.launch() }, modifier = Modifier
                .size(65.dp)
                .offset(x = (-165).dp)) {
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = "Descripción de la imagen",
                    tint = colorResource(id = R.color.secondaryColor), // Set the color of the icon
                    modifier = Modifier.size(60.dp)
                )
            }
            IconButton(onClick = { pickImageLauncher.launch("image/*") }, modifier = Modifier.size(65.dp)) {
                Icon(
                    imageVector = Icons.Default.Image,
                    contentDescription = "Descripción de la imagen",
                    tint = colorResource(id = R.color.secondaryColor), // Set the color of the icon
                    modifier = Modifier.size(60.dp)
                )
            }

    }
}