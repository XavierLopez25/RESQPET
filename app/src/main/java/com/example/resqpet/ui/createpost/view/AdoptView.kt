package com.example.resqpet.ui.createpost.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.resqpet.R
import com.example.resqpet.ui.additionalfeatures.PlaceholderTransformation
import com.example.resqpet.ui.createpost.viewmodel.CreatePostViewModel
import com.example.resqpet.ui.createpost.viewmodel.PostAdoption

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdoptView(postAdoption: PostAdoption?, createPostViewModel: CreatePostViewModel){
    
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = "Post Title",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    postAdoption?.postTitle?.let {
        OutlinedTextField(
            value = postAdoption.postTitle,
            onValueChange = { newValue ->
                createPostViewModel.postAdoption.value =
                    postAdoption.copy(postTitle = newValue)
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
            visualTransformation = if(postAdoption.postTitle.isEmpty()){
                PlaceholderTransformation("Enter the post title")
            } else VisualTransformation.None
        )
    }
    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Pet's Name",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    postAdoption?.petsName?.let {
        OutlinedTextField(
            value = postAdoption.petsName,
            onValueChange = { newValue ->
                createPostViewModel.postAdoption.value =
                    postAdoption.copy(petsName = newValue)
            },
            label = { Text(stringResource(R.string.pet_s_name)) },
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
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(postAdoption.petsName.isEmpty()){
                PlaceholderTransformation("Enter the pet's name")
            } else VisualTransformation.None
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
            postAdoption?.male?.let {
                Checkbox(
                    checked = postAdoption.male,
                    onCheckedChange = { newValue ->
                        createPostViewModel.postAdoption.value =
                            postAdoption.copy(male = newValue)
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
            postAdoption?.female?.let {
                Checkbox(
                    checked = postAdoption.female,
                    onCheckedChange = { newValue ->
                        createPostViewModel.postAdoption.value =
                            postAdoption.copy(female = newValue)
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

    postAdoption?.breed?.let {
        OutlinedTextField(
            value = postAdoption.breed,
            onValueChange = { newValue ->
                createPostViewModel.postAdoption.value =
                    postAdoption.copy(breed = newValue)
            },
            label = { Text("Pet's Breed") },
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
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(postAdoption.breed.isEmpty()){
                PlaceholderTransformation("Enter the breed")
            } else VisualTransformation.None
        )
    }
    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Age of the pet",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    postAdoption?.age?.let {
        OutlinedTextField(
            value = postAdoption.age,
            onValueChange = { newValue ->
                createPostViewModel.postAdoption.value =
                    postAdoption.copy(age = newValue)
            },
            label = { Text(stringResource(R.string.pet_s_age)) },
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
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(postAdoption.age.isEmpty()){
                PlaceholderTransformation("Enter the age")
            } else VisualTransformation.None
        )
    }
    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Post Description",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    postAdoption?.postDescription?.let {
        OutlinedTextField(
            value = postAdoption.postDescription,
            onValueChange = { newValue ->
                createPostViewModel.postAdoption.value =
                    postAdoption.copy(postDescription = newValue)
            },
            label = { Text(stringResource(R.string.post_description)) },
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
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(postAdoption.postDescription.isEmpty()){
                PlaceholderTransformation("Enter the post description")
            } else VisualTransformation.None
        )
    }
    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Pet Personality",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    postAdoption?.petPersonality?.let {
        OutlinedTextField(
            value = postAdoption.petPersonality,
            onValueChange = { newValue ->
                createPostViewModel.postAdoption.value =
                    postAdoption.copy(petPersonality = newValue)
            },
            label = { Text(stringResource(R.string.pet_s_personality)) },
            leadingIcon = {
                Icon(
                    Icons.Default.Pets,
                    contentDescription = "Pet Icon",
                    tint = colorResource(R.color.iconColor)
                )
            },
            placeholder = { Text("Enter pet's personality") },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = colorResource(R.color.backgroundColor),
                focusedIndicatorColor = colorResource(R.color.backgroundColor),
                focusedLabelColor = colorResource(R.color.backgroundColor),
                unfocusedLabelColor = colorResource(R.color.backgroundColor),
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(postAdoption.petPersonality.isEmpty()){
                PlaceholderTransformation("Enter pet's personality")
            } else VisualTransformation.None
        )
    }
    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Contact Info",
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.backgroundColor),
        style = MaterialTheme.typography.titleSmall
    )

    postAdoption?.contactInfo?.let {
        OutlinedTextField(
            value = postAdoption.contactInfo,
            onValueChange = { newValue ->
                createPostViewModel.postAdoption.value =
                    postAdoption.copy(contactInfo = newValue)
            },
            label = { Text(stringResource(R.string.your_contact_info)) },
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
                textColor = colorResource(R.color.primaryColor).copy(alpha = 1f),
                cursorColor = colorResource(R.color.primaryColor)
            ),
            visualTransformation = if(postAdoption.contactInfo.isEmpty()){
                PlaceholderTransformation("Enter your contact info")
            } else VisualTransformation.None
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
            postAdoption?.petCastrated?.let {
                Checkbox(
                    checked = postAdoption.petCastrated,
                    onCheckedChange = { newValue ->
                        createPostViewModel.postAdoption.value =
                            postAdoption.copy(petCastrated = newValue)
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
            postAdoption?.petVaccinated?.let {
                Checkbox(
                    checked = postAdoption.petVaccinated,
                    onCheckedChange = { newValue ->
                        createPostViewModel.postAdoption.value =
                            postAdoption.copy(petVaccinated = newValue)
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