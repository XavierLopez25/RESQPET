package com.example.resqpet.ui.animalprofile.view

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.resqpet.R
import com.example.resqpet.navigation.NavigationState
import com.example.resqpet.ui.animalprofile.viewmodel.AnimalProfileViewModel
import com.example.resqpet.ui.animalprofile.viewmodel.HealthInfo
import com.example.resqpet.ui.createpost.viewmodel.CreatePostViewModel
import com.example.resqpet.ui.mainmenu.viewmodel.MainMenuViewModel

@Composable
fun AnimalProfile(animalId: Int, navController: NavController, postsViewModel: CreatePostViewModel) {

    val viewModel: CreatePostViewModel = postsViewModel

    val animal = viewModel.posts.value?.firstOrNull { it.id == animalId  && it.category == "adoption"}
    LaunchedEffect(key1 = animalId){
        viewModel.fetchPosts()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.backgroundColor))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(colorResource(R.color.secondaryColor))
            ) {
                IconButton(onClick = { navController.navigate(NavigationState.MainMenu.route) }, modifier = Modifier.size(
                    dimensionResource(id = R.dimen.icon_button_size))) {
                    Image(
                        painter = painterResource(id = R.drawable.backbutton2),
                        contentDescription = "Descripción de la imagen",
                    )
                }

                if (animal != null) {
                    Text(
                         stringResource(R.string.hi_i_m) + animal.postAdopt!!.petsName, fontWeight = FontWeight.Bold, fontSize = 23.sp, modifier = Modifier
                            .align(Alignment.CenterStart)
                            .offset(
                                x = dimensionResource(id = R.dimen.text_offset),
                                y = dimensionResource(id = R.dimen.text_offset)
                            ), style = MaterialTheme.typography.titleLarge, color = colorResource(R.color.textColor))
                }

                if (animal != null) {
                    Text(animal.postAdopt!!.breed, modifier = Modifier
                        .align(Alignment.CenterStart)
                        .offset(
                            x = dimensionResource(id = R.dimen.breed_text_offset_x),
                            y = dimensionResource(id = R.dimen.breed_text_offset_y)
                        ), style = MaterialTheme.typography.labelLarge, color = colorResource(R.color.textColor))
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
                            .width(dimensionResource(id = R.dimen.inner_image_box_width))
                            .height(dimensionResource(id = R.dimen.inner_image_box_height))
                            .background(
                                colorResource(R.color.secondaryColor),
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.rounded_corner))
                            )
                            .padding(
                                vertical = dimensionResource(id = R.dimen.image_box_padding_vertical),
                                horizontal = dimensionResource(id = R.dimen.image_box_padding_horizontal)
                            )
                    ) {
                        // Box with the dog image
                        Box(
                            modifier = Modifier
                                .width(dimensionResource(id = R.dimen.dog_image_size))
                                .height(dimensionResource(id = R.dimen.dog_image_size))
                                .background(
                                    colorResource(R.color.backgroundColor),
                                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.rounded_corner))
                                )
                        ) {
                            if (animal?.image != null) {
                                Image(
                                    painter = rememberImagePainter(data = animal.image),
                                    contentDescription = "Image",
                                    modifier = Modifier
                                        .align(Alignment.CenterEnd)
                                        .size(dimensionResource(id = R.dimen.animal_profile_box_height))
                                )
                            } else{
                                Image(
                                    painter = painterResource(id = R.drawable.noimageuploaded),
                                    contentDescription = "Image",
                                    modifier = Modifier
                                        .align(Alignment.CenterEnd)
                                        .size(dimensionResource(id = R.dimen.animal_profile_box_height))
                                )
                            }
                        }
                    }
                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState(), enabled = true)
                    .padding(top = dimensionResource(id = R.dimen.column_padding_top)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    if (animal != null) {
                        ProfileInfoCard(title = stringResource(R.string.description), content = "${animal.postAdopt!!.postDescription}\n" + stringResource(
                                                    R.string.age) + "${animal.postAdopt!!.age}\n" + stringResource(
                                                                                R.string.sex) + if(animal.postAdopt!!.male) "Male" else "Female"
                        )
                    }
                    if (animal != null) {
                        animal.postAdopt!!.petPersonality.let { ProfileInfoCard(title = stringResource(R.string.personality), content = it) }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    if (animal != null) {
                        animal.postAdopt!!.contactInfo?.let { ProfileInfoCard(title = stringResource(R.string.contact_info), content = it) }
                    }
                    if (animal != null) {
                        HealthInfo(
                            animal.postAdopt!!.petVaccinated,
                            animal.postAdopt!!.petCastrated
                        ).let { HealthConditionsCard(it.isVaccinated, it.isCastrated) }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.bottom_box_padding_bottom))
                    .graphicsLayer { translationY = -190f },
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { /* acción cuando se hace clic */ }, modifier = Modifier
                    .size(400.dp)
                    .offset(y = 125.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.adoptbutton),
                        contentDescription = "Descripción de la imagen",
                    )
                }

                Text(text = stringResource(R.string.adopt), style = MaterialTheme.typography.titleLarge, fontSize = 50.sp, color = colorResource(R.color.textColor), modifier = Modifier.offset(y = 155.dp))
            }
        }
    }
}

@Composable
fun ProfileInfoCard(title: String, content: String) {
    Card(
        modifier = Modifier
            .width(dimensionResource(id = R.dimen.profile_info_card_width))
            .height(dimensionResource(id = R.dimen.profile_info_card_height))
            .padding(dimensionResource(id = R.dimen.profile_info_card_padding)),
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.card_elevation)),
        colors = CardDefaults.cardColors(containerColor = (colorResource(R.color.primaryColor)))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState(), enabled = true),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium, fontSize = 20.sp, color = colorResource(R.color.textColor))
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.text_spacer_height)))
            Text(text = content, textAlign = TextAlign.Center, fontSize = 12.sp, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium, color = colorResource(R.color.textColor))
        }
    }
}

@Composable
fun HealthConditionsCard(vaccinatedState: Boolean, castratedState: Boolean) {
    var vaccinated by remember { mutableStateOf(vaccinatedState) }
    var castrated by remember { mutableStateOf(castratedState) }

    Card(
        modifier = Modifier
            .width(dimensionResource(id = R.dimen.profile_info_card_width))
            .height(dimensionResource(id = R.dimen.profile_info_card_height))
            .padding(dimensionResource(id = R.dimen.profile_info_card_padding)),
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.card_elevation)),
        colors = CardDefaults.cardColors(containerColor = (colorResource(R.color.primaryColor)))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.checkbox_row_spacer_width))
                .verticalScroll(rememberScrollState(), enabled = true),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(checked = vaccinated, onCheckedChange = { vaccinated = it }, colors = CheckboxDefaults.colors(uncheckedColor = colorResource(R.color.textColor), checkedColor = colorResource(R.color.secondaryColor)), enabled = false)
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.checkbox_row_spacer_width)))
                Text(text = "Vaccinated",fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelLarge, fontSize = 15.sp, modifier = Modifier.padding(top = 12.dp), color = colorResource(R.color.textColor))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(checked = castrated, onCheckedChange = { castrated = it }, colors = CheckboxDefaults.colors(uncheckedColor = colorResource(R.color.textColor), checkedColor = colorResource(R.color.secondaryColor)), enabled = false)
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.checkbox_row_spacer_width)))
                Text(text = "Castrated",fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelLarge, fontSize = 15.sp, modifier = Modifier.padding(top = 12.dp), color = colorResource(R.color.textColor))
            }
        }
    }
}
