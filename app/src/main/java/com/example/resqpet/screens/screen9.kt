package com.example.resqpet.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resqpet.R


@Preview
@Composable
fun PostFiltering(){

    Column{
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = secondaryColor)
                .align(Alignment.CenterHorizontally)
                .height(100.dp)
                .padding(top = 15.dp, start = 60.dp)
        ){
            SearchBar()
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
                .height(5000.dp)
        ) {
            Column {
                Box(modifier = Modifier.fillMaxWidth().background(primaryColor).align(Alignment.CenterHorizontally)) {
                    LazyRow (modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).clip(RoundedCornerShape(16.dp))) {
                        itemsIndexed(items = listOf("Adoption", "Charity", "Health & Care", "Events")) { _, item ->
                            FilterCheckbox(item)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                val posts = listOf(
                    Post(painterResource(id = R.drawable.doggo6), "Loving Husky seeks warm home.", "Give him a chance! Together, you'll be the perfect team. Adopt and change a life."),
                    Post(painterResource(id = R.drawable.doggo6), "Loving Husky seeks warm home.", "Give him a chance! Together, you'll be the perfect team. Adopt and change a life."),
                    Post(painterResource(id = R.drawable.doggo6), "Loving Husky seeks warm home.", "Give him a chance! Together, you'll be the perfect team. Adopt and change a life."),
                    Post(painterResource(id = R.drawable.doggo6), "Loving Husky seeks warm home.", "Give him a chance! Together, you'll be the perfect team. Adopt and change a life."),
                    Post(painterResource(id = R.drawable.doggo6), "Loving Husky seeks warm home.", "Give him a chance! Together, you'll be the perfect team. Adopt and change a life."),
                    Post(painterResource(id = R.drawable.doggo6), "Loving Husky seeks warm home.", "Give him a chance! Together, you'll be the perfect team. Adopt and change a life.")
                )

                LazyColumn(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(primaryColor)
                        .width(350.dp)
                        .height(600.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    itemsIndexed(items = posts) { _, posts ->
                        PostCard(icon = posts.icon, title = posts.title, description = posts.description)
                    }
                }
            }

        }
    }



}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        textStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = primaryColor,
            cursorColor = primaryColor,
            focusedLabelColor = primaryColor,
            unfocusedLabelColor = primaryColor,
            focusedLeadingIconColor = primaryColor,
            unfocusedLeadingIconColor = primaryColor,
            focusedIndicatorColor = primaryColor,
            unfocusedIndicatorColor = primaryColor,
            containerColor = backgroundColor
        ),
        label = { Text("Search", style = MaterialTheme.typography.titleSmall.copy(fontSize = 14.sp)) },
        trailingIcon = { IconButton(onClick = { /* acción cuando se hace clic */ }, modifier = Modifier.size(40.dp)) { Icon(Icons.Filled.Search, contentDescription = null, tint = primaryColor) } },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .height(70.dp)
    )
}

@Composable
fun PostCard(icon: Painter, title: String, description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(icon, contentDescription = null, modifier = Modifier.size(60.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = description, fontSize = 14.sp)
        }
    }
}

@Composable
fun FilterCheckbox(text: String) {
    var check by remember { mutableStateOf(false)}
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text,fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelLarge, fontSize = 15.sp, color = secondaryColor)
        Checkbox(checked = check, onCheckedChange = { check = it }, colors = CheckboxDefaults.colors(uncheckedColor = secondaryColor, checkedColor = secondaryColor))
        Spacer(modifier = Modifier.width(8.dp))

    }
}

data class Post(val icon: Painter, val title: String, val description: String)

