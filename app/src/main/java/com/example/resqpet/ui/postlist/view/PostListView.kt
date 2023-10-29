package com.example.resqpet.ui.postlist.view

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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.resqpet.R
import com.example.resqpet.ui.postlist.viewmodel.Post
import com.example.resqpet.ui.postlist.viewmodel.PostViewModel

@Composable
fun PostFiltering(navController: NavController) {

    val viewModel: PostViewModel = viewModel()
    val posts by viewModel.posts.observeAsState(emptyList())
    Column{
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(R.color.secondaryColor))
                .align(Alignment.CenterHorizontally)
                .height(100.dp)
                .padding(top = 15.dp, start = 60.dp)
        ){
            SearchBar()
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(R.color.backgroundColor))
                .height(5000.dp)
        ) {
            Column {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(R.color.primaryColor))
                    .align(Alignment.CenterHorizontally)) {
                    LazyRow (modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(16.dp))) {
                        itemsIndexed(items = listOf("Adoption", "Charity", "Health & Care", "Events")) { _, item ->
                            FilterCheckbox(item)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                LazyColumn(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(colorResource(R.color.primaryColor))
                        .width(350.dp)
                        .height(600.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    itemsIndexed(items = posts) { _, post ->
                        PostCard(
                            post = post
                        )
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
            textColor = colorResource(R.color.primaryColor),
            cursorColor = colorResource(R.color.primaryColor),
            focusedLabelColor = colorResource(R.color.primaryColor),
            unfocusedLabelColor = colorResource(R.color.primaryColor),
            focusedLeadingIconColor = colorResource(R.color.primaryColor),
            unfocusedLeadingIconColor = colorResource(R.color.primaryColor),
            focusedIndicatorColor = colorResource(R.color.primaryColor),
            unfocusedIndicatorColor = colorResource(R.color.primaryColor),
            containerColor = colorResource(R.color.backgroundColor)
        ),
        label = { Text(stringResource(R.string.search), style = MaterialTheme.typography.titleSmall.copy(fontSize = 14.sp)) },
        trailingIcon = { IconButton(onClick = { /* acción cuando se hace clic */ }, modifier = Modifier.size(40.dp)) { Icon(
            Icons.Filled.Search, contentDescription = null, tint = colorResource(R.color.primaryColor)
        ) } },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .height(70.dp)
    )
}

@Composable
fun PostCard(post: Post) {
    val iconPainter = painterResource(id = post.iconResId)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = iconPainter, contentDescription = null, modifier = Modifier.size(60.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = post.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = post.description, fontSize = 14.sp)
        }
    }
}



@Composable
fun FilterCheckbox(text: String) {
    var check by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text,fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelLarge, fontSize = 15.sp, color = colorResource(R.color.secondaryColor))
        Checkbox(checked = check, onCheckedChange = { check = it }, colors = CheckboxDefaults.colors(uncheckedColor = colorResource(R.color.secondaryColor), checkedColor = colorResource(R.color.secondaryColor)))
        Spacer(modifier = Modifier.width(8.dp))

    }
}
