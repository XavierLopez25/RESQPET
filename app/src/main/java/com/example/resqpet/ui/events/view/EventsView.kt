package com.example.resqpet.ui.events.view

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.resqpet.R
import com.example.resqpet.ui.events.viewmodel.MainEventViewModel

val primaryColor = Color(0xFF2A5D71)
val backgroundColor = Color(0xFFF4F2DE)
val secondaryColor = Color(0xFFA1CCD1)
val textColor = Color.White

@Preview
@Composable
fun MainEvent() {

    val viewModel: MainEventViewModel = viewModel()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dograce2),
                    contentDescription = "decoration",
                    modifier = Modifier
                        .size(500.dp)
                        .padding(top = 0.dp, start = 0.dp)
                        .align(Alignment.TopEnd)
                        .offset((-30).dp, (-10).dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.bgdeco1),
                    contentDescription = "decoration",
                    modifier = Modifier
                        .size(500.dp)
                        .padding(top = 0.dp, start = 0.dp)
                        .align(Alignment.TopEnd)
                        .offset((180).dp, (-120).dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .offset((0).dp, (-80).dp),
                contentAlignment = Alignment.Center
            ) {
                CardDesign()
            }
        }


        Button(
            onClick = {viewModel.onAssistClicked()},
            colors = ButtonDefaults.buttonColors(containerColor = secondaryColor),
            modifier = Modifier.offset(x = (150).dp, y = (690).dp)

        ) {
            Text("Assist", color = Color.White, style =  MaterialTheme.typography.titleMedium)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDesign() {

    val colorBackground = Color(0xFFF4F2DE)
    val colorIcon = Color(0xFFE9B384)

    val viewModel: MainEventViewModel = viewModel()
    val eventsInfo by viewModel.eventsInfo.collectAsState()

    Column(
        modifier = Modifier
            .width(350.dp)
            .height(425.dp)
            .background(color = primaryColor, shape = RoundedCornerShape(16.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Annual Dog Race!", fontSize = 35.sp, color = Color.White, style =  MaterialTheme.typography.displayLarge)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Foundation Name",
                    fontWeight = FontWeight.Bold,
                    color = colorBackground,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = eventsInfo.name,
                    onValueChange = {},
                    leadingIcon = {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Person Icon",
                            tint = colorIcon
                        )
                    },
                    enabled = false,
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorBackground,
                        focusedIndicatorColor = colorBackground,
                        focusedLabelColor = colorBackground,
                        unfocusedLabelColor = colorBackground,

                        )
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Time of the Event",
                    fontWeight = FontWeight.Bold,
                    color = colorBackground,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = eventsInfo.time,
                    onValueChange = {},
                    leadingIcon = {
                        Icon(
                            Icons.Default.CalendarMonth,
                            contentDescription = "Time Icon",
                            tint = colorIcon
                        )
                    },
                    enabled = false,
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorBackground,
                        focusedIndicatorColor = colorBackground,
                        focusedLabelColor = colorBackground,
                        unfocusedLabelColor = colorBackground,

                        )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Minimum Age",
                    fontWeight = FontWeight.Bold,
                    color = colorBackground,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = eventsInfo.MinimumAge,
                    onValueChange = {},
                    leadingIcon = {
                        Icon(
                            Icons.Default.Check,
                            contentDescription = "Check Icon",
                            tint = colorIcon
                        )
                    },
                    enabled = false,
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorBackground,
                        focusedIndicatorColor = colorBackground,
                        focusedLabelColor = colorBackground,
                        unfocusedLabelColor = colorBackground,

                        )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Minimum Size",
                    fontWeight = FontWeight.Bold,
                    color = colorBackground,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = eventsInfo.MinimumSize,
                    onValueChange = {},
                    leadingIcon = {
                        Icon(
                            Icons.Default.Check,
                            contentDescription = "Check Icon",
                            tint = colorIcon
                        )
                    },
                    enabled = false,
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorBackground,
                        focusedIndicatorColor = colorBackground,
                        focusedLabelColor = colorBackground,
                        unfocusedLabelColor = colorBackground,

                        )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Address of the Event",
                    fontWeight = FontWeight.Bold,
                    color = colorBackground,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = eventsInfo.address,
                    onValueChange = {},
                    leadingIcon = {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = "Home Icon",
                            tint = colorIcon
                        )
                    },
                    enabled = false,
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorBackground,
                        focusedIndicatorColor = colorBackground,
                        focusedLabelColor = colorBackground,
                        unfocusedLabelColor = colorBackground,

                        )
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}


