package com.example.resqpet.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resqpet.R

@Preview
@Composable
fun MainEvent() {
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
                    .graphicsLayer { translationY = -80f },
                contentAlignment = Alignment.Center
            ) {
                CardDesign()
            }
        }
    }
}

@Composable
fun CardDesign() {
    var timeChecked by remember { mutableStateOf(false) }
    var ageChecked by remember { mutableStateOf(false) }
    var sizeChecked by remember { mutableStateOf(false) }

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

        SettingItem("Time", timeChecked) { timeChecked = it }
        SettingItem("Minimum Age", ageChecked) { ageChecked = it }
        SettingItem("Minimum Size", sizeChecked) { sizeChecked = it }

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = secondaryColor)) {
            Text("Assist", color = Color.White, style =  MaterialTheme.typography.titleMedium)
        }
    }
}

@Composable
fun SettingItem(title: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title, color = Color.White, modifier = Modifier.padding(start = 35.dp), fontSize = 16.sp)
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(checkedColor = secondaryColor, uncheckedColor = secondaryColor),
            modifier = Modifier.padding(end = 15.dp)
        )
    }
}