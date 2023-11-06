@file:Suppress("DEPRECATION")

package com.example.resqpet.ui.createpost.view

import android.graphics.Bitmap
import android.net.Uri
import android.content.ContentValues
import android.provider.MediaStore
import android.util.Log
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssignmentTurnedIn
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.resqpet.R
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.resqpet.ui.createpost.viewmodel.CreatePostViewModel
import java.io.ByteArrayOutputStream



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePost(navController: NavController, postsViewModel: CreatePostViewModel) {



    val viewModel: CreatePostViewModel = postsViewModel

    LaunchedEffect(key1 = navController.currentBackStackEntry) {
        viewModel.resetFields()
    }

    val postDataAdopt by viewModel.postAdoption.observeAsState()

    val postDataEventHC by viewModel.postEventHC.observeAsState()
    
    val context = LocalContext.current

    val pickImageLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        // Save the Uri in your ViewModel
        viewModel.saveImageUri(uri)
    }



    val takePictureLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicturePreview()) { bitmap: Bitmap? ->
        if (bitmap != null) {
            println("Success: Bitmap received.")

            // Convert Bitmap to Uri and save it in your ViewModel
            val uri = bitmap.let { imageBitmap ->
                val values = ContentValues().apply {
                    // Ensure unique file name
                    put(MediaStore.Images.Media.DISPLAY_NAME, "Title_${System.currentTimeMillis()}.jpg")
                    put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                }

                val contentResolver = context.contentResolver
                val imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

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




    // Estado para mantener la categoría seleccionada
    var selectedCategory by remember { mutableStateOf("none") }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.backgroundColor))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(colorResource(R.color.secondaryColor))
                .align(Alignment.TopStart)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Create",
                    color = colorResource(R.color.backgroundColor),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(start = 25.dp)
                )
                Text(
                    text = "Post",
                    color = colorResource(R.color.backgroundColor),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(start = 45.dp)
                )
                Text(
                    text = "Unlock Paw-sibilities: ",
                    color = colorResource(R.color.primaryColor),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp)
                )
                Text(
                    text = "Create your Furr-ever Post!",
                    color = colorResource(R.color.primaryColor),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start = 1.dp)
                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .width(185.dp)
                    .height(185.dp)
                    .graphicsLayer(
                        translationX = -25f,
                        translationY = 100f
                    )
                    .background(Color.Transparent)
            ) {

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .width(170.dp)
                        .height(170.dp)
                        .background(
                            colorResource(R.color.secondaryColor),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(vertical = 10.dp, horizontal = 10.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .width(155.dp)
                            .height(155.dp)
                            .background(
                                colorResource(R.color.backgroundColor),
                                shape = RoundedCornerShape(16.dp)
                            )
                    ) {
                        Column(modifier = Modifier.align(Alignment.Center)){

                            Spacer(modifier = Modifier.height(10.dp))

                            // To open gallery
                            Button(onClick = { pickImageLauncher.launch("image/*") }) {
                                Text("Select from Gallery")
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            // To take a picture
                            Button(onClick = { takePictureLauncher.launch() }) {
                                Text("Take a Picture")
                            }
                        }
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .offset((0).dp, (-60).dp)
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

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Text(
                            text = "Post Category",
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.backgroundColor),
                            style = MaterialTheme.typography.titleMedium,
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Checkbox(
                                    checked = selectedCategory == "adoption",
                                    onCheckedChange = { checked ->
                                        if (checked) selectedCategory = "adoption"
                                    }
                                )

                                Text(
                                    text = "Adoption",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Checkbox(
                                    checked = selectedCategory == "event",
                                    onCheckedChange = { checked ->
                                        if (checked) selectedCategory = "event"
                                    }
                                )

                                Text(
                                    text = "Event",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Checkbox(
                                    checked = selectedCategory == "health_care",
                                    onCheckedChange = { checked ->
                                        if (checked) selectedCategory = "health_care"
                                    }
                                )

                                Text(
                                    text = "Health & Care",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                            }
                        }
                    }

                    item {

                        // Muestra los campos de texto basados en la selección
                        when (selectedCategory) {
                            "adoption" -> {

                                Spacer(modifier = Modifier.height(20.dp))
                                Text(
                                    text = "Post Title",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataAdopt?.postTitle?.let {
                                    OutlinedTextField(
                                        value = postDataAdopt?.postTitle ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postAdoption.value =
                                                postDataAdopt?.copy(postTitle = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Book,
                                                contentDescription = "Book Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter the post title") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Pet's Name",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataAdopt?.petsName?.let {
                                    OutlinedTextField(
                                        value = postDataAdopt?.petsName ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postAdoption.value =
                                                postDataAdopt?.copy(petsName = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Pets,
                                                contentDescription = "Pets Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter the pet's name") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Select the sex of the pet",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        postDataAdopt?.male?.let {
                                            Checkbox(
                                                checked = postDataAdopt?.male ?: false,
                                                onCheckedChange = { newValue ->
                                                    viewModel.postAdoption.value =
                                                        postDataAdopt!!.copy(male = newValue)
                                                },
                                                colors = CheckboxDefaults.colors(
                                                    checkedColor = colorResource(R.color.secondaryColor),
                                                    uncheckedColor = colorResource(R.color.backgroundColor)
                                                )
                                            )
                                        }
                                        Text(
                                            text = "Male",
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(R.color.backgroundColor),
                                            style = MaterialTheme.typography.titleSmall
                                        )
                                    }

                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        postDataAdopt?.female?.let {
                                            Checkbox(
                                                checked = postDataAdopt?.female ?: false,
                                                onCheckedChange = { newValue ->
                                                    viewModel.postAdoption.value =
                                                        postDataAdopt!!.copy(female = newValue)
                                                },
                                                colors = CheckboxDefaults.colors(
                                                    checkedColor = colorResource(R.color.secondaryColor),
                                                    uncheckedColor = colorResource(R.color.backgroundColor)
                                                )
                                            )
                                        }
                                        Text(
                                            text = "Female",
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(R.color.backgroundColor),
                                            style = MaterialTheme.typography.titleSmall
                                        )
                                    }
                                }
                                Text(
                                    text = "Breed of the pet",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataAdopt?.breed?.let {
                                    OutlinedTextField(
                                        value = postDataAdopt?.breed ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postAdoption.value =
                                                postDataAdopt?.copy(breed = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Pets,
                                                contentDescription = "Pets Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter the breed") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Age of the pet",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataAdopt?.age?.let {
                                    OutlinedTextField(
                                        value = postDataAdopt?.age ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postAdoption.value =
                                                postDataAdopt?.copy(age = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Pets,
                                                contentDescription = "Pets Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter the age") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Post Description",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataAdopt?.postDescription?.let {
                                    OutlinedTextField(
                                        value = postDataAdopt?.postDescription ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postAdoption.value =
                                                postDataAdopt?.copy(postDescription = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Edit,
                                                contentDescription = "Edit Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter the post description") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Pet Personality",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataAdopt?.petPersonality?.let {
                                    OutlinedTextField(
                                        value = postDataAdopt?.petPersonality ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postAdoption.value =
                                                postDataAdopt?.copy(petPersonality = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Pets,
                                                contentDescription = "Pet Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter the personality") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Contact Info",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataAdopt?.contactInfo?.let {
                                    OutlinedTextField(
                                        value = postDataAdopt?.contactInfo ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postAdoption.value =
                                                postDataAdopt?.copy(contactInfo = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Call,
                                                contentDescription = "Call Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter the your contact info") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Health Condition",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        postDataAdopt?.petCastrated?.let {
                                            Checkbox(
                                                checked = postDataAdopt?.petCastrated ?: false,
                                                onCheckedChange = { newValue ->
                                                    viewModel.postAdoption.value =
                                                        postDataAdopt!!.copy(petCastrated = newValue)
                                                },
                                                colors = CheckboxDefaults.colors(
                                                    checkedColor = colorResource(R.color.secondaryColor),
                                                    uncheckedColor = colorResource(R.color.backgroundColor)
                                                )
                                            )
                                        }
                                        Text(
                                            text = "Castrated",
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(R.color.backgroundColor),
                                            style = MaterialTheme.typography.titleSmall
                                        )
                                    }

                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        postDataAdopt?.petVaccinated?.let {
                                            Checkbox(
                                                checked = postDataAdopt?.petVaccinated ?: false,
                                                onCheckedChange = { newValue ->
                                                    viewModel.postAdoption.value =
                                                        postDataAdopt!!.copy(petVaccinated = newValue)
                                                },
                                                colors = CheckboxDefaults.colors(
                                                    checkedColor = colorResource(R.color.secondaryColor),
                                                    uncheckedColor = colorResource(R.color.backgroundColor)
                                                )
                                            )
                                        }

                                        Text(
                                            text = "Vaccinated",
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(R.color.backgroundColor),
                                            style = MaterialTheme.typography.titleSmall
                                        )
                                    }
                                }
                            }

                            "event", "health_care" -> {

                                Spacer(modifier = Modifier.height(20.dp))
                                Text(
                                    text = "Post Title",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataEventHC?.postTitle?.let {
                                    OutlinedTextField(
                                        value = postDataEventHC?.postTitle ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postEventHC.value =
                                                postDataEventHC?.copy(postTitle = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Book,
                                                contentDescription = "Book Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter the post title") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Foundation Name",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataEventHC?.foundationName?.let {
                                    OutlinedTextField(
                                        value = postDataEventHC?.foundationName ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postEventHC.value =
                                                postDataEventHC?.copy(foundationName = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Group,
                                                contentDescription = "Group Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter the foundation name") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Event Description",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataEventHC?.postDescription?.let {
                                    OutlinedTextField(
                                        value = postDataEventHC?.postDescription ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postEventHC.value =
                                                postDataEventHC?.copy(postDescription = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Event,
                                                contentDescription = "Group Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter the event description") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Minimumm Age",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataEventHC?.minAge?.let {
                                    OutlinedTextField(
                                        value = postDataEventHC?.minAge ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postEventHC.value =
                                                postDataEventHC?.copy(minAge = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.AssignmentTurnedIn,
                                                contentDescription = "Contacts Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter minimum age") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Minimumm Size",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataEventHC?.minSize?.let {
                                    OutlinedTextField(
                                        value = postDataEventHC?.minSize ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postEventHC.value =
                                                postDataEventHC?.copy(minSize = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.AssignmentTurnedIn,
                                                contentDescription = "Contacts Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter your size") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Time of the Event",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataEventHC?.eventTime?.let {
                                    OutlinedTextField(
                                        value = postDataEventHC?.eventTime ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postEventHC.value =
                                                postDataEventHC?.copy(eventTime = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Schedule,
                                                contentDescription = "Schedule Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter the time") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Date of the Event",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataEventHC?.eventDate?.let {
                                    OutlinedTextField(
                                        value = postDataEventHC?.eventDate ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postEventHC.value =
                                                postDataEventHC?.copy(eventDate = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Schedule,
                                                contentDescription = "Schedule Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter the date") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Place of the Event",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataEventHC?.eventPlace?.let {
                                    OutlinedTextField(
                                        value = postDataEventHC?.eventPlace ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postEventHC.value =
                                                postDataEventHC?.copy(eventPlace = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.LocationOn,
                                                contentDescription = "Location Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter the place") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Contact Information",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )

                                postDataEventHC?.foundationContactInfo?.let {
                                    OutlinedTextField(
                                        value = postDataEventHC?.foundationContactInfo ?: "",
                                        onValueChange = { newValue ->
                                            viewModel.postEventHC.value =
                                                postDataEventHC?.copy(foundationContactInfo = newValue)
                                        },
                                        label = { Text(stringResource(R.string.profile)) },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Default.Contacts,
                                                contentDescription = "Contacts Icon",
                                                tint = colorResource(R.color.iconColor)
                                            )
                                        },
                                        placeholder = { Text("Enter your phone number") },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = colorResource(R.color.backgroundColor),
                                            focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                            focusedLabelColor = colorResource(R.color.backgroundColor),
                                            unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                            textColor = colorResource(R.color.primaryColor).copy(alpha = 1f)

                                        )
                                    )
                                }
                            }
                        }
                    }


                }
            }
        }

        IconButton(onClick = { viewModel.resetFields()
                             }, modifier = Modifier
            .size(250.dp)
            .offset(x = (-100).dp, y = 650.dp)) {
            Image(
                painter = painterResource(id = R.drawable.adoptbutton),
                contentDescription = "Descripción de la imagen",
            )
        }
        Text(text = stringResource(R.string.cancel), style = MaterialTheme.typography.titleLarge, fontSize = 25.sp, color = colorResource(R.color.primaryColor), modifier = Modifier.offset(x = 10.dp, y = 780.dp))

        IconButton(onClick = { viewModel.createNewPostWithImage(selectedCategory, postDataAdopt, postDataEventHC)
                             }, modifier = Modifier
            .size(250.dp)
            .offset(x = 250.dp, y = 650.dp)) {
            Image(
                painter = painterResource(id = R.drawable.adoptbutton),
                contentDescription = "Descripción de la imagen",
            )
        }
        Text(text = stringResource(R.string.adopt), style = MaterialTheme.typography.titleLarge, fontSize = 25.sp, color = colorResource(R.color.primaryColor), modifier = Modifier.offset(x = 320.dp, y = 780.dp))



    }
}




