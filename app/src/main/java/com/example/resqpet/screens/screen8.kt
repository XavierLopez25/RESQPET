package com.example.resqpet.screens

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
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.resqpet.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharityRQP() {
    val colorBackground = Color(0xFFF4F2DE)
    val secondaryColor = Color(0xFF2A5D71)
    val colorChart = Color(0xFFA1CCD1)
    val colorIcon = Color(0xFFE9B384)

    var contributorName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    var donateMonetary by remember { mutableStateOf(false) }
    var donateMedicalResources by remember { mutableStateOf(false) }
    var donateFood by remember { mutableStateOf(false) }

    var belongsToFoundation by remember { mutableStateOf(true) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorBackground)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(colorChart)
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
                    text = "Charity",
                    color = colorBackground,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(top = 5.dp, start = 25.dp)
                )
                Text(
                    text = "Embrace Love, Adopt Joy:",
                    color = secondaryColor,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "Be a Paw-sitive Change!",
                    color = secondaryColor,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(top = 3.dp)
                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .width(185.dp)
                    .height(185.dp)
                    .graphicsLayer(
                        translationX = -25f,  // Adjust values to position the box
                        translationY = 100f   // Adjust values to position the box
                    )
                    .background(Color.Transparent)
            ) {
                // Inner white box with content
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .width(170.dp)
                        .height(170.dp)
                        .background(colorChart, shape = RoundedCornerShape(16.dp))
                        .padding(vertical = 10.dp, horizontal = 10.dp)
                ) {
                    // Box with the dog image
                    Box(
                        modifier = Modifier
                            .width(155.dp)
                            .height(155.dp)
                            .background(colorBackground, shape = RoundedCornerShape(16.dp))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.doggo6),
                            contentDescription = "Charity",
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .size(150.dp)
                                .offset((0).dp, (30).dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.heart1),
                            contentDescription = "heart",
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .size(70.dp)
                                .offset((-40).dp, (-40).dp)
                        )
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
                    .background(secondaryColor)
                    .padding(30.dp)
            ) {

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {

                        Text(
                            text = "Contributor Name",
                            fontWeight = FontWeight.Bold,
                            color = colorBackground,
                            style = MaterialTheme.typography.titleMedium,
                        )
                        OutlinedTextField(
                            value = contributorName,
                            onValueChange = { contributorName = it },
                            label = { Text("Profile") },
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Person,
                                    contentDescription = "Person Icon",
                                    tint = colorIcon
                                )
                            },
                            placeholder = { Text("Enter your name") },
                            singleLine = true, // Para mejor visualización y manejo.
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = colorBackground,
                                focusedIndicatorColor = colorBackground,
                                focusedLabelColor = colorBackground,
                                unfocusedLabelColor = colorBackground,
                            )
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "What will you donate to charity?",
                            fontWeight = FontWeight.Bold,
                            color = colorBackground,
                            style = MaterialTheme.typography.titleMedium,
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Checkbox(
                                    checked = donateMonetary,
                                    onCheckedChange = { donateMonetary = it },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorChart,
                                        uncheckedColor = colorBackground
                                    )
                                )
                                Text(
                                    text = "Monetary",
                                    fontWeight = FontWeight.Bold,
                                    color = colorBackground,
                                    style = MaterialTheme.typography.titleSmall
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Checkbox(
                                    checked = donateMedicalResources,
                                    onCheckedChange = { donateMedicalResources = it },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorChart,
                                        uncheckedColor = colorBackground
                                    )
                                )
                                Text(
                                    text = "Medical Resources",
                                    fontWeight = FontWeight.Bold,
                                    color = colorBackground,
                                    style = MaterialTheme.typography.titleSmall
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Checkbox(
                                    checked = donateFood,
                                    onCheckedChange = { donateFood = it },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorChart,
                                        uncheckedColor = colorBackground
                                    )
                                )
                                Text(
                                    text = "Food",
                                    fontWeight = FontWeight.Bold,
                                    color = colorBackground,
                                    style = MaterialTheme.typography.titleSmall
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Do you belong to a foundation?",
                            fontWeight = FontWeight.Bold,
                            color = colorBackground,
                            style = MaterialTheme.typography.titleMedium,
                        )

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Checkbox(
                                checked = belongsToFoundation,
                                onCheckedChange = { belongsToFoundation = it },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = colorChart,
                                    uncheckedColor = colorBackground
                                )
                            )
                            Text(
                                text = "Yes",
                                color = colorBackground,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleSmall
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        if (belongsToFoundation) {
                            Text(
                                text = "Foundation Phone Number",
                                fontWeight = FontWeight.Bold,
                                color = colorBackground,
                                style = MaterialTheme.typography.titleMedium,
                            )
                            OutlinedTextField(
                                value = phoneNumber,
                                onValueChange = { phoneNumber = it },
                                label = { Text("Phone") },
                                leadingIcon = {
                                    Icon(
                                        Icons.Default.Phone,
                                        contentDescription = "Phone Icon",
                                        tint = colorIcon
                                    )
                                },
                                placeholder = { Text("Enter the foundation phone") },
                                singleLine = true, // Para mejor visualización y manejo.
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = colorBackground,
                                    focusedIndicatorColor = colorBackground,
                                    focusedLabelColor = colorBackground,
                                    unfocusedLabelColor = colorBackground,
                                )
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                text = "Foundation Address",
                                fontWeight = FontWeight.Bold,
                                color = colorBackground,
                                style = MaterialTheme.typography.titleMedium,
                            )
                            OutlinedTextField(
                                value = address,
                                onValueChange = { address = it },
                                label = { Text("Address") },
                                leadingIcon = {
                                    Icon(
                                        Icons.Default.House,
                                        contentDescription = "House Icon",
                                        tint = colorIcon
                                    )
                                },
                                placeholder = { Text("Enter the foundation address") },
                                singleLine = true, // Para mejor visualización y manejo.
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = colorBackground,
                                    focusedIndicatorColor = colorBackground,
                                    focusedLabelColor = colorBackground,
                                    unfocusedLabelColor = colorBackground,
                                )
                            )
                        } else {
                            Text(
                                text = "Contributor Phone Number",
                                fontWeight = FontWeight.Bold,
                                color = colorBackground,
                                style = MaterialTheme.typography.titleMedium,
                            )
                            OutlinedTextField(
                                value = phoneNumber,
                                onValueChange = { phoneNumber = it },
                                label = { Text("Phone") },
                                leadingIcon = {
                                    Icon(
                                        Icons.Default.Phone,
                                        contentDescription = "Phone Icon",
                                        tint = colorIcon
                                    )
                                },
                                placeholder = { Text("Enter your phone") },
                                singleLine = true, // Para mejor visualización y manejo.
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = colorBackground,
                                    focusedIndicatorColor = colorBackground,
                                    focusedLabelColor = colorBackground,
                                    unfocusedLabelColor = colorBackground,
                                )
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                text = "Contributor Address",
                                fontWeight = FontWeight.Bold,
                                color = colorBackground,
                                style = MaterialTheme.typography.titleMedium,
                            )
                            OutlinedTextField(
                                value = address,
                                onValueChange = { address = it },
                                label = { Text("Address") },
                                leadingIcon = {
                                    Icon(
                                        Icons.Default.House,
                                        contentDescription = "House Icon",
                                        tint = colorIcon
                                    )
                                },
                                placeholder = { Text("Enter your address") },
                                singleLine = true, // Para mejor visualización y manejo.
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = colorBackground,
                                    focusedIndicatorColor = colorBackground,
                                    focusedLabelColor = colorBackground,
                                    unfocusedLabelColor = colorBackground,
                                )
                            )
                        }
                    }
                }


            }

        }

        IconButton(
            onClick = { /* acción cuando se hace clic */ },
            modifier = Modifier.size(200.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(200.dp)
                    .offset((0).dp, (600).dp)
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
                        text = "Cancel",
                        color = colorBackground,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }

        IconButton(
            onClick = { /* acción cuando se hace clic */ },
            modifier = Modifier.size(200.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset((200).dp, (565).dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.donatebutton),
                    contentDescription = "donation"
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset((-20).dp, (-15).dp)
                ) {

                    Text(
                        text = "Donate",
                        color = colorBackground,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineSmall

                    )

                }
            }

        }
    }

}




