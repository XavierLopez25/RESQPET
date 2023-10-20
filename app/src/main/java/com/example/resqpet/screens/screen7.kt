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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import com.example.resqpet.R
import com.example.resqpet.screens.backgroundColor
import com.example.resqpet.screens.primaryColor
import com.example.resqpet.screens.secondaryColor

@Composable
fun AnimalProfile() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(secondaryColor)
            ) {
                IconButton(onClick = { /* acción cuando se hace clic */ }, modifier = Modifier.size(65.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.backbutton2),
                        contentDescription = "Descripción de la imagen",
                    )
                }

                Text("Hi! I'm Panchito", fontWeight = FontWeight.Bold, fontSize = 25.sp, modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(x = 20.dp, y = 20.dp), style = MaterialTheme.typography.titleLarge, color = Color.White)
                Text("Doberman", modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(x = 80.dp, y = 60.dp), style = MaterialTheme.typography.labelLarge, color = Color.White)


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
                            .background(secondaryColor, shape = RoundedCornerShape(16.dp))
                            .padding(vertical = 10.dp, horizontal = 10.dp)
                    ) {
                        // Box with the dog image
                        Box(
                            modifier = Modifier
                                .width(155.dp)
                                .height(155.dp)
                                .background(backgroundColor, shape = RoundedCornerShape(16.dp))
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.doggo5),
                                contentDescription = "Doberman",
                                modifier = Modifier
                                    .align(Alignment.CenterEnd)
                                    .size(200.dp)
                            )
                        }
                    }
                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState(), enabled = true)
                    .padding(top = 80.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ProfileInfoCard(title = "Description", content = "Information about the size, color, history, etc...")
                    ProfileInfoCard(title = "Personality", content = "Information about the personality of the pet")
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ProfileInfoCard(title = "Contact Info", content = "Information about the personality of the pet")
                    HealthConditionsCard()
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
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

                Text(text = "Adopt", style = MaterialTheme.typography.titleLarge, fontSize = 50.sp, color = Color.White, modifier = Modifier.offset(y = 155.dp))
            }
        }
    }
}

@Composable
fun ProfileInfoCard(title: String, content: String) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = (primaryColor))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState(), enabled = true),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium, fontSize = 20.sp, color = Color.White)
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = content, textAlign = TextAlign.Center, fontSize = 12.sp, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium, color = Color.White)
        }
    }
}

@Composable
fun HealthConditionsCard() {
    var vaccinated by remember { mutableStateOf(false) }
    var castrated by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = (primaryColor))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .verticalScroll(rememberScrollState(), enabled = true),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(checked = vaccinated, onCheckedChange = { vaccinated = it }, colors = CheckboxDefaults.colors(uncheckedColor = Color.White, checkedColor = secondaryColor))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Vaccinated",fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelLarge, fontSize = 15.sp, modifier = Modifier.padding(top = 12.dp), color = Color.White)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(checked = castrated, onCheckedChange = { castrated = it }, colors = CheckboxDefaults.colors(uncheckedColor = Color.White, checkedColor = secondaryColor))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Castrated",fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelLarge, fontSize = 15.sp, modifier = Modifier.padding(top = 12.dp), color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAnimalProfile() {
    AnimalProfile()
}