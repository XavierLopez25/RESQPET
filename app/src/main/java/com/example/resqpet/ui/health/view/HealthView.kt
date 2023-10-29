package com.example.resqpet.ui.health.view

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
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.Person
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.resqpet.ui.health.viewmodel.ServiceRQPViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.resqpet.R
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceRQP(navController: NavController) {

    val viewModel: ServiceRQPViewModel = viewModel()
    val foundation by viewModel.foundationInfo.collectAsState()

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
                    .padding(start = 15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(R.string.health_and),
                    color = colorResource(R.color.backgroundColor),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(start = 5.dp)
                )
                Text(
                    text = stringResource(R.string.care),
                    color = colorResource(R.color.backgroundColor),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(start = 45.dp)
                )
                Text(
                    text = stringResource(R.string.healthy_paws),
                    color = colorResource(R.color.primaryColor),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(top = 10.dp, start = 30.dp)
                )
                Text(
                    text = stringResource(R.string.happy_hearts),
                    color = colorResource(R.color.primaryColor),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start = 30.dp)
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
                        .background(colorResource(R.color.secondaryColor), shape = RoundedCornerShape(16.dp))
                        .padding(vertical = 10.dp, horizontal = 10.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .width(155.dp)
                            .height(155.dp)
                            .background(colorResource(R.color.backgroundColor), shape = RoundedCornerShape(16.dp))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.catto4),
                            contentDescription = "Charity",
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .size(150.dp)
                                .offset((0).dp, (30).dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.heart),
                            contentDescription = "heart",
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .size(70.dp)
                                .offset((-50).dp, (-40).dp)
                        )
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
                            text = stringResource(R.string.foundation_name1),
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.backgroundColor),
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedTextField(
                            value = foundation.name,
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
                            text = stringResource(R.string.time_of_the_event1),
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.backgroundColor),
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedTextField(
                            value = foundation.eventTime,
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
                            text = stringResource(R.string.foundation_address1),
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.backgroundColor),
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedTextField(
                            value = foundation.address,
                            onValueChange = {},
                            leadingIcon = {
                                Icon(
                                    Icons.Default.House,
                                    contentDescription = "Address Icon",
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
                            text = stringResource(R.string.minimum_size1),
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
                                checked = foundation.small,
                                onCheckedChange = {},
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorResource(R.color.secondaryColor),
                                        uncheckedColor = colorResource(R.color.backgroundColor)
                                    ),
                                    enabled = false
                                )
                                Text(
                                    text = stringResource(R.string.small),
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Checkbox(
                                    checked = foundation.medium,
                                    onCheckedChange = {},
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorResource(R.color.secondaryColor),
                                        uncheckedColor = colorResource(R.color.backgroundColor)
                                    ),
                                    enabled = false
                                )
                                Text(
                                    text = stringResource(R.string.medium),
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Checkbox(
                                    checked = foundation.big    ,
                                    onCheckedChange = {},
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorResource(R.color.secondaryColor),
                                        uncheckedColor = colorResource(R.color.backgroundColor)
                                    ),
                                    enabled = false
                                )
                                Text(
                                    text = stringResource(R.string.big),
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )
                            }
                        }

                    }
                }
            }
        }

        IconButton(
            onClick = { viewModel.onCancelClicked() },
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
                        text = stringResource(R.string.cancel2),
                        color = colorResource(R.color.backgroundColor),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }

        IconButton(
            onClick = { viewModel.onRegisterOrDonateClicked() },
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
                        .offset((-50).dp, (-15).dp)
                ) {

                    Text(
                        text = stringResource(R.string.go),
                        color = colorResource(R.color.backgroundColor),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineSmall

                    )

                }
            }
        }
    }
}

