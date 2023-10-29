package com.example.resqpet.ui.start.view

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resqpet.R
import com.example.resqpet.ui.start.viewmodel.ResqpetViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.resqpet.navigation.NavigationState

@Composable
fun MainMenu(navController: NavController) {

    val viewModel: ResqpetViewModel = viewModel()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.secondaryColor)),

        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(370.dp)
                .background(colorResource(R.color.backgroundColor))
                .align(Alignment.TopCenter)
        ){

            Image(
                painter = painterResource(id = R.drawable.house),
                contentDescription = "house image",
                modifier = Modifier
                    .size(230.dp)
                    .padding(top = 0.dp, start = 0.dp)
                    .align(Alignment.TopStart).offset((-55).dp,(-40).dp)

            )}

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            Spacer(modifier = Modifier.height(150.dp))

            Text(
                text = stringResource(R.string.where_second_chances_begin),
                color = colorResource(R.color.primaryColor),
                style = MaterialTheme.typography.titleMedium,
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "RESQPET",
                color = colorResource(R.color.primaryColor),
                fontSize = 30.sp,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(R.string.finding_hope_finding_home),
                color = colorResource(R.color.primaryColor),
                style = MaterialTheme.typography.titleMedium,
            )

            Spacer(modifier = Modifier.height(100.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xFFA1CCD1))

            ){

                Image(
                    painter = painterResource(id = R.drawable.paw1),
                    contentDescription = "paw",
                    modifier = Modifier
                        .size(230.dp)
                        .padding(top = 0.dp, start = 0.dp)
                        .align(Alignment.CenterEnd).offset((55).dp, 10.dp)

                )}
            // Botón Register
            Button(
                onClick = {
                    viewModel.onRegisterClicked()
                    navController.navigate(NavigationState.Register.route) },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.backgroundColor)),
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(10.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(16.dp)

            ) {
                Text(text = "Register", color = colorResource(R.color.primaryColor), fontWeight = FontWeight.Bold, fontSize = 15.sp)

            }

            Button(
                onClick = {
                    viewModel.onLoginClicked()
                    navController.navigate(NavigationState.Login.route) },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.backgroundColor)),
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(10.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Login", color = colorResource(R.color.primaryColor), fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }

            Spacer(modifier = Modifier.height(100.dp))

        }

        Image(
            painter = painterResource(id = R.drawable.catbutton1),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomCenter).offset(0.dp,(-15).dp)
                .padding(bottom = 10.dp)
        )
    }
}
