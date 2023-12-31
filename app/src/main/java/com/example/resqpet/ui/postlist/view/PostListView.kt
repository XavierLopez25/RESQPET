package com.example.resqpet.ui.postlist.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Reply
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
import androidx.compose.runtime.mutableStateListOf
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.resqpet.R
import com.example.resqpet.navigation.NavigationState
import com.example.resqpet.ui.createpost.viewmodel.CreatePostViewModel
import com.example.resqpet.ui.createpost.viewmodel.Post


@SuppressLint("RememberReturnType")
@Composable
fun PostFiltering(navController: NavController, postsViewModel: CreatePostViewModel) {

    val viewModel: CreatePostViewModel = postsViewModel
    val posts by viewModel.posts.observeAsState(emptyList())
    val selectedCategories = remember { mutableStateListOf<String>() }
    var searchQuery by remember { mutableStateOf("") } // Add this line

    val categoryMapping = mapOf(
        "Adoption" to "adoption",
        "Health & Care" to "health_care",
        "Events" to "event"
    )


    Column {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(R.color.secondaryColor))
                    .align(Alignment.CenterHorizontally)
                    .height(100.dp)
                    .padding(top = 15.dp, start = 60.dp)
            ) {
                SearchBar(onQueryChanged = { newQuery -> searchQuery = newQuery })

                IconButton(
                    onClick = { navController.navigate(NavigationState.MainMenu.route){
                        popUpTo(NavigationState.MainMenu.route) { inclusive = true }} },
                    modifier = Modifier.size(70.dp).offset((275).dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.backbutton2),
                        contentDescription = "Regresar a principal",
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(R.color.backgroundColor))
                    .height(5000.dp)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(R.color.primaryColor))
                            .align(Alignment.CenterHorizontally)
                    ) {
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                                .clip(RoundedCornerShape(16.dp))
                        ) {
                            itemsIndexed(items = categoryMapping.keys.toList()) { _, displayName ->
                                FilterCheckbox(displayName) { isChecked ->
                                    val realCategoryName =
                                        categoryMapping[displayName] ?: return@FilterCheckbox
                                    if (isChecked) {
                                        selectedCategories.add(realCategoryName)
                                    } else {
                                        selectedCategories.remove(realCategoryName)
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    val filteredPosts = posts.filter { post ->
                        val isInSelectedCategory = selectedCategories.isEmpty() || post.category in selectedCategories
                        val matchesSearchQuery = searchQuery.isEmpty() ||
                                post.postAdopt?.postTitle?.contains(searchQuery, true) == true ||
                                post.postEvent?.postTitle?.contains(searchQuery, true) == true

                        isInSelectedCategory && matchesSearchQuery
                    }

                    // Check for no matches
                    if (filteredPosts.isEmpty()) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            if (selectedCategories.isEmpty() && searchQuery.isEmpty()) {
                                Text("There are no posts available.", color = colorResource(
                                    id = R.color.errorColor))
                            } else if (selectedCategories.isNotEmpty() && searchQuery.isEmpty()) {
                                Text("There are no posts with this category, be the first to make one!", color = colorResource(
                                    id = R.color.errorColor
                                ))
                            } else if (!searchQuery.isEmpty()) {
                                Text("There are no posts with that name :(", color = colorResource(id = R.color.errorColor))
                            }
                        }
                    } else {
                        LazyColumn(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .background(colorResource(R.color.primaryColor))
                                .width(350.dp)
                                .height(600.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            itemsIndexed(items = filteredPosts) { _, post ->
                                PostCard(
                                    post = post
                                )
                            }
                        }
                    }



                }
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(onQueryChanged: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it
                        onQueryChanged(it)},
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

    val imagePainter = if (post.image != null) {
        rememberImagePainter(data = post.image)
    } else {
        painterResource(id = R.drawable.noimageuploaded)
    }

    val postTitleC: String = if(post.category == "adoption"){
        post.postAdopt!!.postTitle
    } else if ((post.category == "event") || (post.category == "health_care")){
        post.postEvent!!.postTitle
    } else {
        "Title Not Found"
    }

    val postDescC: String = if(post.category == "adoption"){
        post.postAdopt!!.postDescription
    } else if ((post.category == "event") || (post.category == "health_care")){
        post.postEvent!!.postDescription
    } else {
        "Title Not Found"
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(colorResource(id = R.color.secondaryColor))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = imagePainter, contentDescription = null, modifier = Modifier.size(60.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = postTitleC, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = colorResource(id = R.color.primaryColor))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = postDescC, fontSize = 14.sp, color = colorResource(id = R.color.primaryColor))
        }
    }
}



@Composable
fun FilterCheckbox(text: String, onCheckedChange: (Boolean) -> Unit) {
    var check by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelLarge, fontSize = 15.sp, color = colorResource(R.color.secondaryColor))
        Checkbox(checked = check,
            onCheckedChange = {
                check = it
                onCheckedChange(it)
            },
            colors = CheckboxDefaults.colors(uncheckedColor = colorResource(R.color.secondaryColor), checkedColor = colorResource(R.color.secondaryColor))
        )
        Spacer(modifier = Modifier.width(8.dp))
    }
}
