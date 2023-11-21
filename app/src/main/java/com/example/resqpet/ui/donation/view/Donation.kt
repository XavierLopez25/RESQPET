package com.example.resqpet.ui.donation.view

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
import com.example.resqpet.ui.donation.viewmodel.DonationViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Donation(navController: NavController) {
    val viewModel: DonationViewModel = viewModel()
    val donationData by viewModel.donationData.observeAsState()
    val contributorName by remember { mutableStateOf("") }
    val phoneNumber by remember { mutableStateOf("") }
    val address by remember { mutableStateOf("") }
    val donateMonetary by remember { mutableStateOf(false) }
    val donateMedicalResources by remember { mutableStateOf(false) }
    val donateFood by remember { mutableStateOf(false) }
    var belongsToFoundation by remember { mutableStateOf(true) }

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
                    text = stringResource(R.string.charity),
                    color = colorResource(R.color.backgroundColor),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(top = 5.dp, start = 25.dp)
                )
                Text(
                    text = stringResource(R.string.embrace_love_adopt_joy),
                    color = colorResource(R.color.primaryColor),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = stringResource(R.string.be_a_paw_sitive_change),
                    color = colorResource(R.color.primaryColor),
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
                            text = "Contributor Name",
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.backgroundColor),
                            style = MaterialTheme.typography.titleMedium,
                        )
                        donationData?.contributorName?.let {
                            OutlinedTextField(
                                value = it,
                                onValueChange = { newValue ->
                                    viewModel.donationData.value = donationData?.copy(contributorName = newValue)
                                },
                                label = { Text(stringResource(R.string.profile)) },
                                leadingIcon = {
                                    Icon(
                                        Icons.Default.Person,
                                        contentDescription = "Person Icon",
                                        tint = colorResource(R.color.iconColor)
                                    )
                                },
                                placeholder = { Text("Enter your name") },
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
                            text = stringResource(R.string.what_will_you_donate_to_charity),
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.backgroundColor),
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
                                donationData?.donateMonetary?.let {
                                    Checkbox(
                                        checked = it,
                                        onCheckedChange = { newValue ->
                                            viewModel.donationData.value = donationData!!.copy(donateMonetary = newValue)
                                        },
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = colorResource(R.color.secondaryColor),
                                            uncheckedColor = colorResource(R.color.backgroundColor)
                                        )
                                    )
                                }
                                Text(
                                    text = stringResource(R.string.monetary),
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                donationData?.donateMedicalResources?.let {
                                    Checkbox(
                                        checked = it,
                                        onCheckedChange = { newValue ->
                                            viewModel.donationData.value = donationData!!.copy(donateMedicalResources = newValue)
                                        },
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = colorResource(R.color.secondaryColor),
                                            uncheckedColor = colorResource(R.color.backgroundColor)
                                        )
                                    )
                                }
                                Text(
                                    text = stringResource(R.string.medical_resources),
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                donationData?.donateFood?.let {
                                    Checkbox(
                                        checked = it,
                                        onCheckedChange = { newValue ->
                                            viewModel.donationData.value = donationData!!.copy(donateFood = newValue)
                                        },
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = colorResource(R.color.secondaryColor),
                                            uncheckedColor = colorResource(R.color.backgroundColor)
                                        )
                                    )
                                }
                                Text(
                                    text = stringResource(R.string.food),
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleSmall
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = stringResource(R.string.do_you_belong_to_a_foundation),
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.backgroundColor),
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                           belongsToFoundation
                                Checkbox(
                                    checked = belongsToFoundation,
                                    onCheckedChange = { belongsToFoundation = it },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorResource(R.color.secondaryColor),
                                        uncheckedColor = colorResource(R.color.backgroundColor)
                                    )
                                )
                            Text(
                                text = stringResource(R.string.yes),
                                color = colorResource(R.color.backgroundColor),
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        if (belongsToFoundation) {
                            Text(
                                text = stringResource(R.string.foundation_phone_number),
                                fontWeight = FontWeight.Bold,
                                color = colorResource(R.color.backgroundColor),
                                style = MaterialTheme.typography.titleMedium,
                            )
                            donationData?.let {
                                OutlinedTextField(
                                    value = it.phoneNumber,
                                    onValueChange = {  newValue ->
                                        viewModel.donationData.value = donationData!!.copy(phoneNumber = newValue)
                                    },
                                    label = { Text(stringResource(R.string.phone)) },
                                    leadingIcon = {
                                        Icon(
                                            Icons.Default.Phone,
                                            contentDescription = "Phone Icon",
                                            tint = colorResource(R.color.iconColor)
                                        )
                                    },
                                    placeholder = { Text(stringResource(R.string.enter_the_foundation_phone)) },
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
                                text = stringResource(R.string.foundation_address),
                                fontWeight = FontWeight.Bold,
                                color = colorResource(R.color.backgroundColor),
                                style = MaterialTheme.typography.titleMedium,
                            )
                            donationData?.let {
                                OutlinedTextField(
                                    value = it.address,
                                    onValueChange = {  newValue ->
                                        viewModel.donationData.value = donationData!!.copy(address = newValue)
                                    },
                                    label = { Text(stringResource(R.string.address)) },
                                    leadingIcon = {
                                        Icon(
                                            Icons.Default.House,
                                            contentDescription = "House Icon",
                                            tint = colorResource(R.color.iconColor)
                                        )
                                    },
                                    placeholder = { Text(stringResource(R.string.enter_the_foundation_address)) },
                                    singleLine = true,
                                    colors = TextFieldDefaults.textFieldColors(
                                        containerColor = colorResource(R.color.backgroundColor),
                                        focusedIndicatorColor = colorResource(R.color.backgroundColor),
                                        focusedLabelColor = colorResource(R.color.backgroundColor),
                                        unfocusedLabelColor = colorResource(R.color.backgroundColor),
                                    )
                                )
                            }
                        } else {
                            Text(
                                text = stringResource(R.string.contributor_phone_number),
                                fontWeight = FontWeight.Bold,
                                color = colorResource(R.color.backgroundColor),
                                style = MaterialTheme.typography.titleMedium,
                            )
                            donationData?.let {
                                OutlinedTextField(
                                    value = it.phoneNumber,
                                    onValueChange = {  newValue ->
                                        viewModel.donationData.value = donationData!!.copy(phoneNumber = newValue)
                                    },
                                    label = { Text(stringResource(R.string.phone)) },
                                    leadingIcon = {
                                        Icon(
                                            Icons.Default.Phone,
                                            contentDescription = "Phone Icon",
                                            tint = colorResource(R.color.iconColor)
                                        )
                                    },
                                    placeholder = { Text(stringResource(R.string.enter_your_phone)) },
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
                                text = stringResource(R.string.contributor_address),
                                fontWeight = FontWeight.Bold,
                                color = colorResource(R.color.backgroundColor),
                                style = MaterialTheme.typography.titleMedium,
                            )
                            donationData?.let {
                                OutlinedTextField(
                                    value = it.address,
                                    onValueChange = {  newValue ->
                                        viewModel.donationData.value = donationData!!.copy(address = newValue)
                                    },
                                    label = { Text(stringResource(R.string.address)) },
                                    leadingIcon = {
                                        Icon(
                                            Icons.Default.House,
                                            contentDescription = "House Icon",
                                            tint = colorResource(R.color.iconColor)
                                        )
                                    },
                                    placeholder = { Text(stringResource(R.string.enter_your_address)) },
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
        IconButton(
            onClick = { viewModel.cancelDonation("", "", "", donateMonetary = false, donateMedicalResources = false, donateFood = false) },
            modifier = Modifier.size(125.dp)
                .offset((1).dp, (65).dp)
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
                        text = stringResource(R.string.cancel),
                        color = colorResource(R.color.backgroundColor),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
        IconButton(
            onClick = { viewModel.submitDonation(contributorName, phoneNumber, address, donateMonetary, donateMedicalResources, donateFood) },
            modifier = Modifier.size(125.dp).offset((10).dp, (65).dp)
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
                        text = stringResource(R.string.donate),
                        color = colorResource(R.color.backgroundColor),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
    }
}