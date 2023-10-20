package com.example.resqpet.screens

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resqpet.R

@Composable
fun ResqpetScreen() {

    val colorBackground = Color(0xFFA1CCD1)
    val colorButtons = Color(0xFFF4F2DE)
    val colorText = Color(0xFF2A5D71)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorBackground),

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(370.dp)
                .background(colorButtons)
                .align(Alignment.TopCenter)
        ){

        Image(
            painter = painterResource(id = R.drawable.house),
            contentDescription = "house image",
            modifier = Modifier
                .size(230.dp)  // haz la imagen más grande; ajusta según tus necesidades
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
                text = "WHERE SECOND CHANCES BEGIN",
                color = colorText,
                style = MaterialTheme.typography.titleMedium,
            )

            Spacer(modifier = Modifier.height(15.dp))

            // Texto "RESQPET"
            Text(
                text = "RESQPET",
                color = colorText,
                fontSize = 30.sp,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(15.dp))

            // Texto "FINDING HOPE, FINDING HOME"
            Text(
                text = "FINDING HOPE, FINDING HOME",
                color = colorText,
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
                onClick = { /* Acción para Register */ },
                colors = ButtonDefaults.buttonColors(colorButtons),
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(10.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(16.dp)

            ) {
                Text(text = "Register", color = colorText, fontWeight = FontWeight.Bold, fontSize = 15.sp)

            }

            // Botón Login
            Button(
                onClick = { /* Acción para Login */ },
                colors = ButtonDefaults.buttonColors(colorButtons),
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(10.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Login", color = colorText, fontWeight = FontWeight.Bold, fontSize = 15.sp)
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


