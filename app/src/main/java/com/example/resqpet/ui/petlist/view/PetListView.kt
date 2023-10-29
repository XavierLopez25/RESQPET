package com.example.resqpet.ui.petlist.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.resqpet.R
import com.example.resqpet.ui.petlist.viewmodel.Pet
import com.example.resqpet.ui.petlist.viewmodel.PetListViewModel


@Composable
fun PetList(navController: NavController) {


    val viewModel: PetListViewModel = viewModel()
    val pets = viewModel.pets

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.backgroundColor)),

        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()

        ) {
            Image(
                painter = painterResource(id = R.drawable.catbutton1),
                contentDescription = "decoration",
                modifier = Modifier
                    .size(80.dp)
                    .padding(top = 0.dp, start = 0.dp)
                    .align(Alignment.TopStart)
                    .offset((1).dp, (10).dp)
            )
            IconButton(
                onClick = { /* acción cuando se hace clic */ },
                modifier = Modifier.size(100.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.backbutton1),
                    contentDescription = "Regresar a principal",
                    modifier = Modifier
                        .size(80.dp)
                        .offset((280).dp, (0).dp)
                )
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(100.dp))

                Text(
                    text = stringResource(R.string.welcome1),
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.primaryColor),
                    style = MaterialTheme.typography.headlineMedium,
                )

                Spacer(modifier = Modifier.height(1.dp))

                Text(
                    text = stringResource(R.string.rescue_a_heart_adopt_a_friend),
                    color = colorResource(R.color.primaryColor),
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.height(10.dp))

                LazyColumn(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxHeight()
                ) {
                    itemsIndexed(items = pets) { _, pets ->
                        PetCard(pet = pets)
                    }
                }

            }
        }

    }
}

@Composable
fun PetCard(pet: Pet, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(100.dp),
        shape = RoundedCornerShape(30.dp),
    ) {
        Row(
            modifier = Modifier.background(Color(0xFF2A5D71)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = pet.imageResId),
                contentDescription = pet.name,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 2.dp, end = 10.dp, top = 10.dp, bottom = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Text(
                    text = pet.name,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFF4F2DE)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "${pet.age}  |  ${pet.gender}  |  ${pet.breed}", color = Color(0xFFF4F2DE), style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
