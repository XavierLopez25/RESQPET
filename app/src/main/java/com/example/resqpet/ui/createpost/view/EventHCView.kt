package com.example.resqpet.ui.createpost.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssignmentTurnedIn
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.resqpet.R
import com.example.resqpet.ui.additionalfeatures.PlaceholderTransformation
import com.example.resqpet.ui.createpost.viewmodel.CreatePostViewModel
import com.example.resqpet.ui.createpost.viewmodel.PostEventHC

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventHCView(eventHC: PostEventHC?, createPostViewModel: CreatePostViewModel){

    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = "Post Title",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    eventHC?.postTitle?.let {
        OutlinedTextField(
            value = eventHC.postTitle,
            onValueChange = { newValue ->
                createPostViewModel.postEventHC.value =
                    eventHC.copy(postTitle = newValue)
            },
            label = { Text(stringResource(R.string.post_title)) },
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
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(eventHC.postTitle.isEmpty()){
                PlaceholderTransformation("Enter the post title")
            } else VisualTransformation.None
        )
    }
    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Foundation Name",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    eventHC?.foundationName?.let {
        OutlinedTextField(
            value = eventHC.foundationName,
            onValueChange = { newValue ->
                createPostViewModel.postEventHC.value =
                    eventHC.copy(foundationName = newValue)
            },
            label = { Text(stringResource(R.string.foundation_s_name)) },
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
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(eventHC.foundationName.isEmpty()){
                PlaceholderTransformation("Enter the post title")
            } else VisualTransformation.None
        )
    }
    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Event Description",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    eventHC?.postDescription?.let {
        OutlinedTextField(
            value = eventHC.postDescription,
            onValueChange = { newValue ->
                createPostViewModel.postEventHC.value =
                    eventHC.copy(postDescription = newValue)
            },
            label = { Text(stringResource(R.string.post_description)) },
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
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(eventHC.postDescription.isEmpty()){
                PlaceholderTransformation("Enter the post title")
            } else VisualTransformation.None
        )
    }

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Minimum Age",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    eventHC?.minAge?.let {
        OutlinedTextField(
            value = eventHC.minAge,
            onValueChange = { newValue ->
                createPostViewModel.postEventHC.value =
                    eventHC.copy(minAge = newValue)
            },
            label = { Text(stringResource(R.string.minimum_age)) },
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
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(eventHC.minAge.isEmpty()){
                PlaceholderTransformation("Enter the post title")
            } else VisualTransformation.None
        )
    }

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Minimum Size",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    eventHC?.minSize?.let {
        OutlinedTextField(
            value = eventHC.minSize,
            onValueChange = { newValue ->
                createPostViewModel.postEventHC.value =
                    eventHC.copy(minSize = newValue)
            },
            label = { Text(stringResource(R.string.minimum_size)) },
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
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(eventHC.minSize.isEmpty()){
                PlaceholderTransformation("Enter the post title")
            } else VisualTransformation.None
        )
    }

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Time of the Event",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    eventHC?.eventTime?.let {
        OutlinedTextField(
            value = eventHC.eventTime,
            onValueChange = { newValue ->
                createPostViewModel.postEventHC.value =
                    eventHC.copy(eventTime = newValue)
            },
            label = { Text(stringResource(R.string.time_of_the_event)) },
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
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(eventHC.eventTime.isEmpty()){
                PlaceholderTransformation("Enter the post title")
            } else VisualTransformation.None
        )
    }
    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Date of the Event",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    eventHC?.eventDate?.let {
        OutlinedTextField(
            value = eventHC.eventDate,
            onValueChange = { newValue ->
                createPostViewModel.postEventHC.value =
                    eventHC.copy(eventDate = newValue)
            },
            label = { Text(stringResource(R.string.date_of_event)) },
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
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(eventHC.eventDate.isEmpty()){
                PlaceholderTransformation("Enter the post title")
            } else VisualTransformation.None
        )
    }
    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Place of the Event",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    eventHC?.eventPlace?.let {
        OutlinedTextField(
            value = eventHC.eventPlace,
            onValueChange = { newValue ->
                createPostViewModel.postEventHC.value =
                    eventHC.copy(eventPlace = newValue)
            },
            label = { Text(stringResource(R.string.event_place)) },
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
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(eventHC.eventPlace.isEmpty()){
                PlaceholderTransformation("Enter the post title")
            } else VisualTransformation.None
        )
    }
    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Contact Information",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    eventHC?.foundationContactInfo?.let {
        OutlinedTextField(
            value = eventHC.foundationContactInfo,
            onValueChange = { newValue ->
                createPostViewModel.postEventHC.value =
                    eventHC.copy(foundationContactInfo = newValue)
            },
            label = { Text(stringResource(R.string.foundation_s_contact_info)) },
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
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(eventHC.foundationContactInfo.isEmpty()){
                PlaceholderTransformation("Enter the post title")
            } else VisualTransformation.None
        )
    }
}