package com.example.resqpet.ui.createpost.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Schedule
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.resqpet.ui.createpost.viewmodel.CreatePostViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePost() {

    val viewModel: CreatePostViewModel = viewModel()

    val postDataAdopt by viewModel.postAdoption.observeAsState()

    val postDataEventHC by viewModel.postEventHC.observeAsState()

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
                        // Imagen para agregar en el post
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd).offset((0).dp, (-60).dp)
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
                                        value = it,
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

                                postDataAdopt?.postTitle?.let {
                                    OutlinedTextField(
                                        value = it,
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
                                                checked = it,
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
                                                checked = it,
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
                                        value = it,
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
                                        value = it,
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
                                        value = it,
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
                                        value = it,
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
                                        value = it,
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
                                                checked = it,
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
                                                checked = it,
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
                                        value = it,
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

                                postDataEventHC?.postTitle?.let {
                                    OutlinedTextField(
                                        value = it,
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

                                postDataEventHC?.postTitle?.let {
                                    OutlinedTextField(
                                        value = it,
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

                                postDataEventHC?.postTitle?.let {
                                    OutlinedTextField(
                                        value = it,
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

                                postDataEventHC?.postTitle?.let {
                                    OutlinedTextField(
                                        value = it,
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

                                postDataEventHC?.postTitle?.let {
                                    OutlinedTextField(
                                        value = it,
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

                                postDataEventHC?.postTitle?.let {
                                    OutlinedTextField(
                                        value = it,
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
                                        )
                                    )
                                }
                            }
                        }
                    }


                }
            }
        }

        IconButton(
            onClick = { viewModel.cancelDonation() },
            modifier = Modifier.size(200.dp)
                .offset((1).dp, (65).dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(200.dp)
                    .offset((0).dp, (530).dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cancelbutton),
                    contentDescription = "cancel"
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(200.dp)
                        .offset((-35).dp, (35).dp)
                ) {
                    Text(
                        text = stringResource(R.string.cancel),
                        color = colorResource(R.color.backgroundColor),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }

        IconButton(
            onClick = { viewModel.submitDonation() },
            modifier = Modifier.size(200.dp).offset((20).dp, (65).dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset((180).dp, (500).dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.donatebutton),
                    contentDescription = "donation"
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset((-35).dp, (-15).dp)
                ) {

                    Text(
                        text = "Post",
                        color = colorResource(R.color.backgroundColor),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineSmall

                    )

                }
            }
        }

    }
}




