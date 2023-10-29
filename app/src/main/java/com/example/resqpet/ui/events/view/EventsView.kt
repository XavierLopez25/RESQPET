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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.resqpet.R
import com.example.resqpet.ui.events.viewmodel.MainEventViewModel

@Composable
fun MainEvent(navController: NavController) {

    val viewModel: MainEventViewModel = viewModel()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.backgroundColor))
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
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.secondaryColor)),
            modifier = Modifier.offset(x = (150).dp, y = (690).dp)

        ) {
            Text(stringResource(R.string.assist), color = Color.White, style =  MaterialTheme.typography.titleMedium)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDesign() {
    
    val viewModel: MainEventViewModel = viewModel()
    val eventsInfo by viewModel.eventsInfo.collectAsState()

    Column(
        modifier = Modifier
            .width(350.dp)
            .height(425.dp)
            .background(color = colorResource(R.color.primaryColor), shape = RoundedCornerShape(16.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(stringResource(R.string.annual_dog_race), fontSize = 35.sp, color = Color.White, style =  MaterialTheme.typography.displayLarge)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(R.string.foundation_name),
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.backgroundColor),
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
                            tint = colorResource(R.color.iconColor)
                        )
                    },
                    enabled = false,
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorResource(R.color.backgroundColor),
                        focusedIndicatorColor = colorResource(R.color.backgroundColor),
                        focusedLabelColor = colorResource(R.color.backgroundColor),
                        unfocusedLabelColor = colorResource(R.color.backgroundColor),

                        )
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(R.string.time_of_the_event),
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.backgroundColor),
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
                            tint = colorResource(R.color.iconColor)
                        )
                    },
                    enabled = false,
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorResource(R.color.backgroundColor),
                        focusedIndicatorColor = colorResource(R.color.backgroundColor),
                        focusedLabelColor = colorResource(R.color.backgroundColor),
                        unfocusedLabelColor = colorResource(R.color.backgroundColor),

                        )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = stringResource(R.string.minimum_age),
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.backgroundColor),
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
                            tint = colorResource(R.color.iconColor)
                        )
                    },
                    enabled = false,
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorResource(R.color.backgroundColor),
                        focusedIndicatorColor = colorResource(R.color.backgroundColor),
                        focusedLabelColor = colorResource(R.color.backgroundColor),
                        unfocusedLabelColor = colorResource(R.color.backgroundColor),

                        )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = stringResource(R.string.minimum_size),
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.backgroundColor),
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
                            tint = colorResource(R.color.iconColor)
                        )
                    },
                    enabled = false,
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorResource(R.color.backgroundColor),
                        focusedIndicatorColor = colorResource(R.color.backgroundColor),
                        focusedLabelColor = colorResource(R.color.backgroundColor),
                        unfocusedLabelColor = colorResource(R.color.backgroundColor),

                        )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = stringResource(R.string.address_of_the_event),
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.backgroundColor),
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
                            tint = colorResource(R.color.iconColor)
                        )
                    },
                    enabled = false,
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorResource(R.color.backgroundColor),
                        focusedIndicatorColor = colorResource(R.color.backgroundColor),
                        focusedLabelColor = colorResource(R.color.backgroundColor),
                        unfocusedLabelColor = colorResource(R.color.backgroundColor),

                        )
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}


