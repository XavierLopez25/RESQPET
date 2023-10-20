package com.example.resqpet.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.resqpet.R

val primaryColor = Color(0xFF2A5D71)
val backgroundColor = Color(0xFFF4F2DE)
val secondaryColor = Color(0xFFA1CCD1)
val textColor = Color.White
@Preview
@Composable
fun PetAppUI() {


    var selectedItem by remember { mutableStateOf(0) }
    listOf("Home", "Search", "Add", "Health", "Profile")

    Column (modifier = Modifier.fillMaxSize()){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = backgroundColor)
                .weight(0.5f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.catbutton1),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(60.dp)
                            .absoluteOffset(0.dp, 0.dp),
                        alignment = Alignment.BottomEnd
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                ) {
                    Text(
                        text = "Hello!",
                        color = primaryColor,
                        fontSize = 50.sp,
                        style = MaterialTheme.typography.displayLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Image(
                        painter = painterResource(id = R.drawable.paw2),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                            .absoluteOffset(75.dp, 0.dp),
                        alignment = Alignment.BottomEnd
                    )
                }

                Text(
                    text = "Whisker you looking for? Tail us",
                    color = primaryColor,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "and find your purrfect match here!",
                    color = primaryColor,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                val cardItems =  listOf(CardItem("Adopt", R.drawable.heart), CardItem("Events", R.drawable.shelter1), CardItem("Charity", R.drawable.shelter2))

                LazyRow {
                    itemsIndexed(items = cardItems) { _, item ->
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .size(
                                    width = 200.dp,
                                    height = 100.dp
                                )
                                .clickable { /* Handle click */ },
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = primaryColor
                            ),
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = item.title,
                                    color = textColor,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .align(Alignment.CenterStart)
                                        .padding(8.dp)
                                )

                                Spacer(modifier = Modifier.height(15.dp))

                                Image(
                                    painter = painterResource(id = item.imageResId),
                                    contentDescription = item.title,
                                    modifier = Modifier.fillMaxSize(),
                                    alignment = Alignment.CenterEnd
                                )
                            }
                        }
                    }
                }
            }
        }

        PostsBar(Modifier.weight(0.5f))
    }

}

@Composable
fun PostsBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(primaryColor)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomEnd

    ) {
        Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.Bottom) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()

            ) {
                Text(text = "Latest Posts", color = textColor, fontSize = 16.sp)
                Button(
                    modifier = Modifier
                        .padding(1.dp),
                    onClick = { /* Handle Save Action */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFA1CCD1)
                    )
                ) {
                    Text(text = " See all posts -> ", color = Color(0xFFF4F2DE), fontSize = 20.sp)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            val examplePostsList = listOf(
                CardItem("Cute Cat", R.drawable.doggo1),
                CardItem("Playful Dog", R.drawable.doggo2),
                CardItem("Cute Cat", R.drawable.catto4),
                CardItem("Playful Dog", R.drawable.catto8),
                CardItem("Cute Cat", R.drawable.doggo3),
                CardItem("Playful Dog", R.drawable.doggo4),
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                itemsIndexed(items = examplePostsList) { _, item  ->
                    PostCard(postItem = item)
                }
            }
        }
    }



    // Bottom Navigation Bar
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(secondaryColor)
            .padding(8.dp)
            .height(40.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home Icon",
            tint = primaryColor,
        )
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Icon",
            tint = primaryColor
        )
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add Icon",
            tint = primaryColor
        )
        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = "Health Icon",
            tint = primaryColor
        )
        Icon(
            imageVector = Icons.Default.Face,
            contentDescription = "Profile Icon",
            tint = primaryColor
        )
    }
}

@Composable
fun PostCard(postItem: CardItem) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = secondaryColor),

    ) {
        Column {
            Text(
                text = postItem.title,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.labelLarge,
                color = textColor,
                textAlign = TextAlign.Center

            )
            Image(
                painter = painterResource(id = postItem.imageResId),
                contentDescription = "Content image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
            )
        }
    }
}

data class CardItem(
    val title: String,
    val imageResId: Int
)
